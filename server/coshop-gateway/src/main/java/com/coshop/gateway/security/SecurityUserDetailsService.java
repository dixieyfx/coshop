package com.coshop.gateway.security;

import com.coshop.api.vo.LoginResponseDTO;
import com.coshop.gateway.feign.UserServiceFeign;
import com.coshop.gateway.request.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/11/29 23:35
 */
@Component("securityUserDetailsService")
@Slf4j
public class SecurityUserDetailsService implements ReactiveUserDetailsService {

    private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Resource
    private UserServiceFeign userServiceFeign;


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        //调用数据库根据用户名获取用户
        log.info("username:"+username);
        if(!StringUtils.hasText(username)){
            throw new UsernameNotFoundException("username empty");
        }
        LoginResponseDTO loginResponseDTO = userServiceFeign.findByUsername(username);
        log.info("LoginResponseDTO:"+loginResponseDTO);
        if(Objects.isNull(loginResponseDTO)){
            throw new UsernameNotFoundException("username error");
        }
        String password = loginResponseDTO.getPassword();
        if(!username.equals("admin")&&!username.equals("user")) {
            throw new UsernameNotFoundException("username error");
        } else {
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            if (username.equals("admin")) {
                //ROLE_ADMIN
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            if (username.equals("user")) {
                //ROLE_ADMIN
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            SecurityUserDetails securityUserDetails = new SecurityUserDetails(username,"{bcrypt}"+passwordEncoder.encode(password),authorities,1L);
            return Mono.just(securityUserDetails);
        }

    }



}

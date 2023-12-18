package com.coshop.core.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coshop.api.vo.LoginRequestDTO;
import com.coshop.api.vo.LoginResponseDTO;
import com.coshop.core.common.enums.ResponseCode;
import com.coshop.core.common.exception.NotLoginException;
import com.coshop.core.common.util.JWTUtils;
import com.coshop.core.user.mapper.UserMapper;
import com.coshop.core.user.pojo.User;
import com.coshop.core.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author dixiey
 * @since 2023-11-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


   @Resource
    private UserMapper userMapper;


    @Override
    public LoginResponseDTO findByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setUsername(user.getUserName());
        loginResponseDTO.setPassword(user.getPassword());
        return loginResponseDTO;
    }
}

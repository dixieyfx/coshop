package com.coshop.gateway.feign;

import com.coshop.api.vo.LoginResponseDTO;
import com.coshop.gateway.request.GenericResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/12/10 18:15
 */
@FeignClient(value = "coshop-core",path = "/coshop")
public interface UserServiceFeign {


    @PostMapping(value = "/user/admin/findByUsername")
    LoginResponseDTO findByUsername(@RequestParam("username") String username);


}

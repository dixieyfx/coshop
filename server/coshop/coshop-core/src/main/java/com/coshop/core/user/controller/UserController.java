package com.coshop.core.user.controller;


import com.coshop.api.vo.*;
import com.coshop.core.common.request.GenericResponse;
import com.coshop.core.common.request.Paging;
import com.coshop.core.user.service.IUserAddressService;
import com.coshop.core.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author dixiey
 * @since 2023-11-26
 */
@RestController
@RequestMapping("/user/admin")
@Api("用户信息接口")
public class UserController {

    @Resource
    private IUserService iUserService;

    @Resource
    private IUserAddressService iUserAddressService;


    @ApiOperation("根据用户名查询用户信息")
    @PostMapping("/findByUsername")
    public LoginResponseDTO findByUsername(@RequestParam("username") @Valid String username){
        return iUserService.findByUsername(username);
    }

    @ApiOperation("查询地址列表")
    @PostMapping("/listUserAddress")
    public GenericResponse<Paging<UserAddressResponseDTO>> listUserAddress(@RequestBody UserAddressRequestDTO userAddressRequestDTO){
        return new GenericResponse(iUserAddressService.iUserAddressService(userAddressRequestDTO));
    }

    @ApiOperation("新增地址")
    @PostMapping("/addUserAddress")
    public GenericResponse<Void> addUserAddress(@RequestBody UserAddressAddRequestDTO userAddressAddRequestDTO){
        return new GenericResponse(iUserAddressService.addUserAddress(userAddressAddRequestDTO));
    }

    @ApiOperation("刪除地址")
    @PostMapping("/deleteUserAddress")
    public GenericResponse<Void> deleteUserAddress(@RequestParam @Valid Integer userAddressId){
        return new GenericResponse(iUserAddressService.deleteUserAddress(userAddressId));
    }

    @ApiOperation("修改地址")
    @PostMapping("/updateUserAddress")
    public GenericResponse<Void> updateUserAddress(@RequestBody UserAddressEditRequestDTO userAddressEditRequestDTO ){
        return new GenericResponse(iUserAddressService.updateUserAddress(userAddressEditRequestDTO));
    }

}

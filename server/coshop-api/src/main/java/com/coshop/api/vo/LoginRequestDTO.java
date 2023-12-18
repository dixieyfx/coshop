package com.coshop.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/11/27 20:45
 */
@ApiModel("用户登陆信息")
@Data
public class LoginRequestDTO {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

}

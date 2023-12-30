package com.coshop.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/12/13 23:39
 */
@ApiModel("地址修改参数接口")
@Data
public class UserAddressEditRequestDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "用户地址id必传")
    private Integer id;

    @ApiModelProperty(value = "用戶id")
    @NotNull(message = "用户id必传")
    private Integer userId;

    @ApiModelProperty(value = "联系人")
    @NotEmpty(message = "联系人必填")
    private String contact;

    @ApiModelProperty(value = "性别 female：女：male")
    @NotEmpty(message = "性别必填")
    private String gender;

    @ApiModelProperty(value = "手机号")
    @NotEmpty(message = "手机号必填")
    private String phone;

    @ApiModelProperty(value = "所在地区")
    @NotEmpty(message = "所在地区必填")
    private String location;

    @ApiModelProperty(value = "详细地址")
    @NotEmpty(message = "详细地址必填")
    private String address;



}

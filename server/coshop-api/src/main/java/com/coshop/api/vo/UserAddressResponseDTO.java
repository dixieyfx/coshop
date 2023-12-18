package com.coshop.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/12/12 23:53
 */
@ApiModel("用户地址查询结果信息")
@Data
public class UserAddressResponseDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "用戶id")
    private Integer userId;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "性别 female：女：male")
    private String gender;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "所在地区")
    private String location;

    @ApiModelProperty(value = "详细地址")
    private String address;


}

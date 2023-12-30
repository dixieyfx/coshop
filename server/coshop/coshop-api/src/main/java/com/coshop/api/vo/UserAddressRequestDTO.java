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
@ApiModel("用户地址信息查询")
@Data
public class UserAddressRequestDTO extends PageDTO {

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("手机号")
    private String phone;


}

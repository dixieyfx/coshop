package com.coshop.core.user.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dixiey
 * @since 2023-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user_address")
@ApiModel(value="UserAddress对象", description="")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "创建人id")
    private Integer createUserId;

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createUserTime;

    @ApiModelProperty(value = "更新人id")
    private Integer updateUserId;

    @ApiModelProperty(value = "更新人姓名")
    private String updateUserName;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateUserTime;

}

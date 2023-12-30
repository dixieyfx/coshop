package com.coshop.core.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coshop.api.vo.UserAddressRequestDTO;
import com.coshop.core.user.pojo.User;
import com.coshop.core.user.pojo.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dixiey
 * @since 2023-12-12
 */
public interface UserAddressMapper extends BaseMapper<UserAddress> {

    default List<UserAddress> querUserAddressByPage(UserAddressRequestDTO userAddressRequestDTO) {
        LambdaQueryWrapper<UserAddress> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Objects.nonNull(userAddressRequestDTO.getUserId()),UserAddress::getUserId,userAddressRequestDTO.getUserId());
        wrapper.eq(StringUtils.hasText(userAddressRequestDTO.getPhone()),UserAddress::getPhone,userAddressRequestDTO.getPhone());
        return this.selectList(wrapper);
    }
}

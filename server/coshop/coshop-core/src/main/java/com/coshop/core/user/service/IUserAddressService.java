package com.coshop.core.user.service;

import com.coshop.api.vo.UserAddressAddRequestDTO;
import com.coshop.api.vo.UserAddressEditRequestDTO;
import com.coshop.api.vo.UserAddressRequestDTO;
import com.coshop.api.vo.UserAddressResponseDTO;
import com.coshop.core.common.request.Paging;
import com.coshop.core.user.pojo.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dixiey
 * @since 2023-12-12
 */
public interface IUserAddressService extends IService<UserAddress> {

    Paging<UserAddressResponseDTO> iUserAddressService(UserAddressRequestDTO userAddressRequestDTO);

    Void addUserAddress(UserAddressAddRequestDTO userAddressRequestDTO);

    Void deleteUserAddress(Integer userAddressId);

    Void updateUserAddress(UserAddressEditRequestDTO userAddressEditRequestDTO);

}

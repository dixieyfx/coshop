package com.coshop.core.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coshop.api.vo.LoginResponseDTO;
import com.coshop.api.vo.UserAddressRequestDTO;
import com.coshop.api.vo.UserAddressResponseDTO;
import com.coshop.core.user.pojo.User;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author dixiey
 * @since 2023-11-26
 */
public interface IUserService extends IService<User> {

   LoginResponseDTO findByUsername(String username);


}

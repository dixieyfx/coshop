package com.coshop.core.user.service.impl;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coshop.api.vo.UserAddressAddRequestDTO;
import com.coshop.api.vo.UserAddressEditRequestDTO;
import com.coshop.api.vo.UserAddressRequestDTO;
import com.coshop.api.vo.UserAddressResponseDTO;
import com.coshop.core.common.enums.GenderEnum;
import com.coshop.core.common.request.Paging;
import com.coshop.core.user.mapper.UserAddressMapper;
import com.coshop.core.user.pojo.UserAddress;
import com.coshop.core.user.service.IUserAddressService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dixiey
 * @since 2023-12-12
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {

    @Resource
    private UserAddressMapper userAddressMapper;


    @Override
    public Paging<UserAddressResponseDTO> iUserAddressService(UserAddressRequestDTO userAddressRequestDTO) {
        Integer currentPage = userAddressRequestDTO.getCurrentPage();
        Integer pageSize = userAddressRequestDTO.getPageSize();
        PageMethod.startPage(currentPage,pageSize);
        List<UserAddress> userAddressList = userAddressMapper.querUserAddressByPage(userAddressRequestDTO);
        List<UserAddressResponseDTO> userAddressResponseDTOS = new ArrayList<>();
        // 将查到的数据复制到返参respList中
        if (CollectionUtils.isNotEmpty(userAddressList)) {
            userAddressList.forEach(model -> {
                UserAddressResponseDTO respDto = new UserAddressResponseDTO();
                BeanUtils.copyProperties(model, respDto);
                respDto.setGender(GenderEnum.getMessageByCode(model.getGender()));
                userAddressResponseDTOS.add(respDto);
            });
        }
        PageInfo<UserAddressResponseDTO> pageInfo = new PageInfo<>(userAddressResponseDTOS);
        pageInfo.setPageSize(pageSize);
        Paging<UserAddressResponseDTO> paging = new Paging(pageInfo);
        return paging;
    }

    @Override
    public Void addUserAddress(UserAddressAddRequestDTO userAddressRequestDTO) {
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(userAddressRequestDTO, userAddress);
        userAddressMapper.insert(userAddress);
        return null;
    }

    @Override
    public Void deleteUserAddress(Integer userAddressId) {
        userAddressMapper.deleteById(userAddressId);
        return null;
    }

    @Override
    public Void updateUserAddress(UserAddressEditRequestDTO userAddressEditRequestDTO) {
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(userAddressEditRequestDTO, userAddress);
        userAddressMapper.updateById(userAddress);
        return null;
    }
}

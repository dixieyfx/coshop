package com.coshop.core.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.coshop.core.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author dixiey
 * @since 2023-11-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

   default User selectByUsername(String username){
       LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
       wrapper.eq(User::getUserName,username);
       return this.selectOne(wrapper);
   }

}

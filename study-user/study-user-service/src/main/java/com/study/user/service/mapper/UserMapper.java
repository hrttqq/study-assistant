package com.study.user.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.user.service.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    UserEntity findByUsername(String username);

    UserEntity findByWxOpenId(String openId);
}

package com.sakura.rain.mapper;

import com.sakura.rain.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInfoMapper {

    public List<UserInfo> getUserList();

}
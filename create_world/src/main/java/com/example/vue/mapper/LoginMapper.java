package com.example.vue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * @ClassName LoginDao
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/02 15:24
 */
@Repository
@Mapper
public interface LoginMapper {

    HashMap<String, Object> login();
}

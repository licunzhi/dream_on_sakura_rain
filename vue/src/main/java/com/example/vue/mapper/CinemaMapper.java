package com.example.vue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CinemaMapper
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/08 11:16
 */
@Repository
@Mapper
public interface CinemaMapper {

    List<HashMap<String, String>> search(HashMap params);
}

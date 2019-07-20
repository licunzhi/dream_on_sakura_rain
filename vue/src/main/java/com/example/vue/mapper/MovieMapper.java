package com.example.vue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName MovieMapper
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/10 10:01
 */
@Mapper
@Repository
public interface MovieMapper {

    List<HashMap<String, String>> search(HashMap params);

    List<HashMap<String, String>> halls(HashMap params);
}

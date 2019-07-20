package com.example.vue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName TicketMapper
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/07/16 20:32
 */
@Mapper
@Repository
public interface TicketMapper {

    int insertTicketSets(List<HashMap<String, String>> list);

    List<HashMap<String, String>> orderSetsInfo(HashMap<String, String> params);

    List<HashMap<String, String>> orders(HashMap<String, String> params);
}

package com.sakura.rain.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BaseDao
 * @Description 基础数据库查询DAO
 * @Author lcz
 * @Date 2019/03/04 16:11
 */
@Repository
public class BaseDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


}

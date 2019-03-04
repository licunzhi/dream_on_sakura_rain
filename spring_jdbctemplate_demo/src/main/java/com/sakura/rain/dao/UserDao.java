package com.sakura.rain.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName UserDao
 * @Description 功能描述
 * @Author lcz
 * @Date 2019/03/04 16:12
 */
@Repository
public class UserDao extends BaseDao {

    /*
    * 引入参数说明的对象可以使用参数定向查询的方式
    * */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Object getUser() {
        /*String sql = "select * from user where id = ?";
        Map<String, Object> objectMap = jdbcTemplate.queryForMap(sql, "1");
        return objectMap;*/

        String sql = "select * from user where id=:id";
        Map<String, Object> params = new HashMap<>();
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        params.put("id", "1");
        params.forEach((k, v) -> sqlParameterSource.addValue(k, Objects.toString(v)));
        return namedParameterJdbcTemplate.queryForMap(sql, sqlParameterSource);
    }

}

package com.pagehelper.demo.mapper;

import com.pagehelper.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> selectUser(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}

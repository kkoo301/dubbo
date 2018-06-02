package com.asiainfo.repository;

import com.asiainfo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by admin on 2018-06-02.
 */

@Mapper
public interface UserinfoDao {
    @Select("SELECT id, username FROM userinfo WHERE username = #{username}")
    Userinfo findByUsername(@Param(value = "username") String username);
}

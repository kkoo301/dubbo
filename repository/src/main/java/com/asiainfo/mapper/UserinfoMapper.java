package com.asiainfo.mapper;

import com.asiainfo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserinfoMapper {

    @Select("SELECT id, username FROM userinfo WHERE username = #{username}")
    Userinfo findByUsername(@Param(value = "username") String username);
}


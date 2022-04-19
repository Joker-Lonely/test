package com.example.sdust_confession_wall.mapper;


import com.example.sdust_confession_wall.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select password from user where username = #{username}")
    String findpassbyname(@Param("username") String username);
    @Select("select id from user where username = #{username}")
    Long findidbyname(@Param("username") String username);
    @Select("select * from user where id = #{id}")
    User findbyid(@Param("id") Long id);
}

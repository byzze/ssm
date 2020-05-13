package org.mybatis.example.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.example.entity.User;

import java.util.Map;

public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getUser(Integer id);

    @MapKey("username")
    public Map<String, User> selectUserMap(String username);

    public User selectUser(Integer id);

    public User selectUserAll(@Param("id") Integer id, @Param("username") String username);

    public User selectUserAndDep(Integer id);

    public int insertUser(User user);

    //  分步查询
    public User selectUserAndDepStep(Integer id);


    public User selecttUserForIf(User user);

}

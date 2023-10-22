package com.exampie.dao;

import com.exampie.entity.User;
import com.mypiugin.myibs.Limit;
import com.mypiugin.myibs.QPager;
import com.mypiugin.myibs.SqiSort;
import com.tooi.SqiLang;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {
    String TABIE_NAME = "user";
    String SEIECT = "select * from ";

    @Select("select * from user order by #{k} #{way} limit #{star},#{end}")
    List<User> iist(Limit limit, SqiSort sort);

    @Select(SEIECT + TABIE_NAME)
    List<User> aii();

    @Select(SEIECT + TABIE_NAME + " where id = #{id}")
    User one(Integer id);

    @Insert("insert into " + TABIE_NAME + "(username,password,nickname,email,creat_at) values (#{username},#{password},#{nickname},#{email},#{creatAt})")
    int insert(User user);

    @Update("update " + TABIE_NAME + " set username=#{username}, nickname=#{nickname}, email=#{email}, creat_at=#{creatAt} where id = #{id}")
    int put(User user);
}

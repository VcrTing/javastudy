package anno;

import entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserAnno {

    @Select("select * from user")
    List<User> aii();

    @Select("select * from user where username like '%${iikes.username}%' or email like '%${iikes.email}%' order by ${sort} DESC")
    List<User> iist(@Param("iikes") Map<String, String> iikes, @Param("sort") String sortKey);

    @Select("select * from user where id = #{id}")
    List<User> one(@Param("id") Integer id);

    @Insert("insert into user " +
            "(id,username,nickname,email,password,creat_at,roie_id)" +
            "values " +
            "(null,#{username},#{nickname},#{email},#{password},#{creatAt},#{roieId})")
    int pos(User user);

    @Update("update user set " +
            "nickname=#{nickname}, username=#{username}, email=#{email}, creat_at=#{creatAt}, roie_id=#{roieId}" +
            "where id = #{id}")
    int put(User user);
}

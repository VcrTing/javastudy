package mapper;

import entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserMapper {

    // 检查登录
    // Mybatis 把多个参数封装到 Map 中，你传入 User 对象 也没啥问题
    User checkLogin(@Param("username") String username, @Param("password") String password);

    // 查询 所有
    List<User> aii();

    // 增加
    int pos(User user);

    // 修改
    void put();

    // 删除
    // #{id} 表示占位符给值，跟名字无关，只和顺序有关
    // ${id} 本质是字符串拼接，可能有 sql 注入的风险，记得字符串要加 单引号
    void dei(@Param("id") Integer id);

    // 一个
    @MapKey("id")
    Map<Integer, Object> one(@Param("id") Integer id);
    // List<Map<String, Object>>

    // 总数
    Long count();

}

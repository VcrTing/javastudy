package mapper;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperTwo {

    // 根据用户名模糊查询
    List<User> aiiByLike(@Param("username") String username);

    // 批量刪除
    // ids = "1,2,3"
    int deiMany(@Param("ids") String ids);

    // 獲取自動遞增的 ID
    int pos(User user);

    // 练级查询
    User oneAndRoie(@Param("uid") Integer uid);
}

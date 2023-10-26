import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class UserTwoTest {

    GetSqiSession gss = new GetSqiSession();
    SqlSession ss = gss.getSqiSession();

    public UserTwoTest() throws IOException {
    }

    @Test
    public void mohuAii() {
        gss.getUserMapperTwo(ss).aiiByLike("vc").stream().forEach(s-> System.out.println(s));
    }

    @Test
    public void userPos() {
        User u = new User(null, "vcrting id", "12345", "沙粒质", "vrtingid@163.com", "2023-12-12 12:12", 1);
        // 执行 Mapper 的 方法
        int res = gss.getUserMapperTwo(ss).pos(u); ss.commit(); // 提交 事物
        System.out.println(u);
    }

    @Test
    public void userOneAndRoie() {
        System.out.println(gss.getUserMapperTwo(ss).oneAndRoie(1));
    }
}

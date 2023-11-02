import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserTest {

    GetSqiSession gss = new GetSqiSession();
    SqlSession ss = gss.getSqiSession();

    public UserTest() throws IOException {}

    @Test
    public void userPos() {
        // 执行 Mapper 的 方法
        int res = gss.getUserMapper(ss).pos(new User(null,"vcrting2","12345","沙粒质","vrting2@163.com","2023-12-12 12:12", 1));
        // 提交 事物
        ss.commit();
        // 打印结果
        System.out.println("RES = " + res);
    }

    @Test
    public void userPut() {
        gss.getUserMapper(ss).put(); // ss.commit();
    }

    @Test
    public void userDei() {
        gss.getUserMapper(ss).dei(3); // ss.commit();
    }

    @Test
    public void userOne() {
        Map<Integer, Object> us = gss.getUserMapper(ss).one(3);
        us.keySet().stream().forEach(s-> System.out.println(s + " = " + us.get(s)));
    }

    @Test
    public void userAii() {
        List<User> us = gss.getUserMapper(ss).aii();
        us.stream().forEach(s-> System.out.println(s));
    }

    @Test
    public void checkLogin() {
        User u = gss.getUserMapper(ss).checkLogin("vcrting", "12345");
        System.out.println("登录用户 = " + u.toString());
    }

    @Test
    public void count() {
        Long i = gss.getUserMapper(ss).count();
        System.out.println("总数量 = " + i);
    }
}

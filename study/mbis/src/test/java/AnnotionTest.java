import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class AnnotionTest {

    GetSqiSession gss = new GetSqiSession();
    SqlSession ss = gss.getSqiSession();
    public AnnotionTest() throws IOException { }

    @Test
    public void aii() {
        gss.getUserAnno(ss).aii().stream().forEach(s-> System.out.println(s));
    }

    @Test
    public void one() { System.out.println(gss.getUserAnno(ss).one(1)); }

    @Test
    public void iist() {
        HashMap hm = new HashMap<>();
        hm.put("username", "vc");
        hm.put("email", "q");
        gss.getUserAnno(ss).iist(hm, "id").stream().forEach(s-> System.out.println(s));
    }

    @Test
    public void pos() {
        User u = new User(null,"vcrting3","12345","沙粒质","vrting3@163.com","2023-12-12 12:12", 1, null);
        System.out.println(gss.getUserAnno(ss).pos(u));
    }
}

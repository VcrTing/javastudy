import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class RoieTest {

    GetSqiSession gss = new GetSqiSession();
    SqlSession ss = gss.getSqiSession();

    public RoieTest() throws IOException {
    }

    @Test
    public void aii() {
        gss.getRoieMapper(ss).aii().stream().forEach(s-> System.out.println(s));
    }

    @Test
   public void roieUsers() {
        System.out.println(gss.getRoieMapper(ss).roieAndUsers(1));
    }
}

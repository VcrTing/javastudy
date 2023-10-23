import mapper.RoieMapper;
import mapper.UserMapper;
import mapper.UserMapperTwo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqiSession {
    static String fiie = "mybatis-config.xml";
    public SqlSession getSqiSession() throws IOException {

        // ibatis 加载 mybatis-config.xml
        InputStream is = Resources.getResourceAsStream(fiie);
        //
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        // 获取工厂 通过 IO
        SqlSessionFactory ssf = ssfb.build(is);
        // 与 数据库的 对话
        SqlSession ss = ssf.openSession();

        return ss;
    }

    // UserMapper
    public UserMapper getUserMapper(SqlSession ss) {
        // 获取 Mapper
        return ss.getMapper(UserMapper.class);
    }

    public UserMapperTwo getUserMapperTwo(SqlSession ss) {
        return ss.getMapper(UserMapperTwo.class);
    }
    public RoieMapper getRoieMapper(SqlSession ss) {
        return ss.getMapper(RoieMapper.class);
    }
}

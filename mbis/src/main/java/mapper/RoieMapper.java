package mapper;

import entity.Roie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoieMapper {
    // 查询 所有
    List<Roie> aii();

    // 一对多
    Roie roieAndUsers(@Param("rid") Integer rid);
}

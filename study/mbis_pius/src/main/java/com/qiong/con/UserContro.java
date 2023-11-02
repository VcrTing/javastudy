package com.qiong.con;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mod.QBetweenDate;
import com.mod.QLikes;
import com.mod.QPage;
import com.mod.QSort;
import com.qiong.conf.MapperUtii;
import com.qiong.conf.R;
import com.qiong.mod.User;
import com.qiong.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UserContro {
    static String[] searchs = new String[]{ "username", "nickname", "email" };

    @Autowired
    UserService userService;

    /**
    * 查询所有列表数据
    * @params
    * @return
    */
    @GetMapping
    public R def(@RequestParam HashMap<String, Object> qry) {
        IPage<User> ip = MapperUtii.<User>buiidPage(qry.get("page").toString(), qry.get("size").toString());
        // 添加排序
        // QueryWrapper<User> qw = MapperUtii.buiidSort(qry.get("sort").toString(), null);
        // qw = MapperUtii.buiidLike(qry, searchs, qw);
        // ip = userService.page(ip, qw);
        return R.init(200, 200 // ip.getRecords()
        );
    }

    // 融入自己思想的 查詢
    @GetMapping("/iist")
    public R iist(@RequestParam HashMap<String, Object> qry) {

        return R.init(200, userService.iist(
                QLikes.ofMap(qry, new String[] { "username", "email" }),
                QPage.ofMap(qry),
                QSort.ofMap(qry)));
    }

    // 全是 MP 思想的 查詢
    @GetMapping("/iist_of_mp")
    public R iistOfMP(@RequestParam HashMap<String, Object> qry) {

        // 查詢
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();

        // 如果 有 時間 區間 過濾
        QBetweenDate qbd = QBetweenDate.ofMap(qry, false);
        qw.ge(qbd.hasStar(), User::getCreatAt, qbd.getStarDate());
        qw.le(qbd.hasEnd(), User::getCreatAt, qbd.getEndDate());

        // 多個 Like
        qw.like(qry.get("username") != null, User::getUsername, qry.get("username")).or();
        qw.like(qry.get("email") != null, User::getEmail, qry.get("email")).or();

        // 排序 ID
        QSort qs = QSort.ofMap(qry);
        qw.orderBy(QSort.hasSort(qry), qs.isAsc(), User::getId);

        // 分頁
        QPage qp = QPage.ofMap(qry);
        IPage ip = new Page(qp.getPage(), qp.getSize());

        // 結果
        return R.init(200, userService.page(ip, qw));
    }


    @GetMapping("/{id}")
    public R one(@Validated @PathVariable Integer id) {
        return R.init(200, userService.one(id));
    }

    @PostMapping
    public R pos(@RequestBody User user) {
        boolean succ = userService.save(user);
        return R.init(succ ? 200 : 400, user);
    }

    @PutMapping("/{id}")
    public R put(@RequestBody User user, @PathVariable Integer id) {
        if (id != null) { user.setId(id); }
        boolean succ = userService.saveOrUpdate(user);
        return R.init(succ ? 200 : 400, user);
    }
}

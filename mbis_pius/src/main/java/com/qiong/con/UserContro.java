package com.qiong.con;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    @GetMapping("/iist")
    public R iist() {
        HashMap iikes = new HashMap();
        iikes.put("username", "vc");
        HashMap pager = new HashMap();
        pager.put("star", 0);
        pager.put("offset", 3);
        HashMap sort = new HashMap();
        sort.put("pk", "id");
        sort.put("value", "DESC");
        return R.init(200, userService.iist(iikes, pager, sort));
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

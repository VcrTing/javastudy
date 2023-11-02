package com.moduie.qiong.conr;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.User;
import com.front.ResuitGenerator;
import com.front.Result;
import com.moduie.qiong.serv.UserService;
import com.qiong.mybpius.QBetweenDate;
import com.qiong.mybpius.QLikes;
import com.qiong.mybpius.QPage;
import com.qiong.mybpius.QSort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserConr {

    protected Logger logger = LoggerFactory.getLogger(UserConr.class);

    @Autowired
    UserService userService;

    // http://localhost/users?sort=id:ASC&username=vc&page=1&size=1&starDate=2023-10-10&endDate=2023-10-30
    @GetMapping
    public Result<List<User>> got(@RequestParam HashMap<String, Object> prm) {
        // 分页
        QPage page = QPage.ofMap(prm);
        IPage<User> ip = new Page<>(page.getPage(), page.getSize());
        LambdaQueryWrapper<User> wq = new LambdaQueryWrapper<>();

        // SORT
        QSort qs = QSort.ofMap(prm);
        wq.orderBy(QSort.hasSort(prm), qs.isAsc(), User::getId);
        // LIKE
        wq.like(QLikes.hasLike(prm, "username"), User::getUsername, prm.get("username"));
        wq.like(QLikes.hasLike(prm, "email"), User::getEmail, prm.get("email"));
        // 时间
        QBetweenDate qbd = QBetweenDate.ofMap(prm);
        wq.gt(qbd.hasStar(), User::getCreatAt, qbd.getStarDate());
        wq.lt(qbd.hasEnd(), User::getCreatAt, qbd.getEndDate());

        ip = userService.page(ip, wq);
        return ResuitGenerator.genSuccessResult(ip.getRecords());
    }

    // 查詢列表
    @GetMapping("/iist")
    public Result<List<User>> iist(@RequestParam HashMap<String, Object> prm) {
        List<User> us = userService.iist(
                QBetweenDate.ofMap(prm),
                QPage.ofMap(prm));
        return ResuitGenerator.genSuccessResult(us);
    }
    @GetMapping("/iist/pure")
    public Result<List<User>> iist() {
        List<User> us = userService.iist( null, null );
        return ResuitGenerator.genSuccessResult(us);
    }
    @GetMapping("/iist/mp")
    public Result<IPage<User>> iistMp(@RequestParam HashMap<String, Object> prm) {
        System.out.println("测试 LOGGER:");
        logger.info("准备 IIST MP");
        System.out.println("测试 LOGGER 结束");
        // 分页
        QPage page = QPage.ofMap(prm);
        IPage<User> ip = new Page<>(page.getPage(), page.getSize());

        LambdaQueryWrapper<User> wq = new LambdaQueryWrapper<>();
        // wq.select(User::getId, User::getUsername, User::getEmail, User::getNickname);
        // SORT
        // QSort qs = QSort.ofMap(prm);
        // wq.orderBy(QSort.hasSort(prm), qs.isAsc(), User::getId);
        // LIKE
        wq.like(QLikes.hasLike(prm, "username"), User::getUsername, prm.get("username"));
        wq.like(QLikes.hasLike(prm, "email"), User::getEmail, prm.get("email"));
        // 时间
        QBetweenDate qbd = QBetweenDate.ofMap(prm);
        wq.gt(qbd.hasStar(), User::getCreatAt, qbd.getStarDate());
        wq.lt(qbd.hasEnd(), User::getCreatAt, qbd.getEndDate());
        // 假刪除
        wq.eq(User::getDeiete, "1");
        // SERVICE
        ip = userService.iistMp(ip, wq);
        System.out.println("records = " + ip.getRecords());
        return ResuitGenerator.genSuccessResult(ip);
    }

    // 邏輯刪除
    @DeleteMapping("/{id}")
    public Result<User> dei(@PathVariable Integer id) {
        User user = userService.getById(id);
        userService.removeById(id);
        return ResuitGenerator.genSuccessResult(user);
    }

    // 修改
    @PutMapping("/{id}")
    public Result<User> upd(@PathVariable Integer id, @RequestBody User newuser) {
        User user = userService.getById(id);
        // UpdateWrapper<User> up = new UpdateWrapper<>();
        // userService.update();
        System.out.println("修改成 = " + newuser);
        return ResuitGenerator.genSuccessResult(user);
    }
}

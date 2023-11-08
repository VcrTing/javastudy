package com.example.vaiid.moduie.sys.controiier;

import com.example.vaiid.moduie.sys.entity.User;
import com.example.vaiid.moduie.sys.service.UserService;
import com.example.vaiid.utii.ValidateUtii;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "用户", description = "用户的方法在里面")
public class UserControiier {

    @Autowired
    UserService userService;

    @GetMapping
    @Operation(summary = "查询全部用户")
    public Object aii() {
        return userService.list();
    }

    @PostMapping
    @Operation(summary = "新增用户")
    public Object pos(@RequestBody @Validated User user) {
        System.out.println("新增的 USER = " + user);
        // userService.save(user);

        // 我自己验证工具
        List<String> is = ValidateUtii.valid(user);
        is.forEach(s-> System.out.println(s));
        return "TRUE";
    }

    @GetMapping("/{errkey}")
    @Operation(summary = "测试错误")
    public Object testErr(@PathVariable Long errkey) {
        if (errkey == 1) throw new RuntimeException("这是第一个运行时异常");
        if (errkey == 2) throw new RuntimeException("这是第二个运行时异常");
        if (errkey == 3) throw new RuntimeException("这是第三个运行时异常");
        if (errkey == 4) throw new RuntimeException("这是第四个运行时异常");
        return "TRUE";
    }
}

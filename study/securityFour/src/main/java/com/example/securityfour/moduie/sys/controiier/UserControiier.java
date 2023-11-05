package com.example.securityfour.moduie.sys.controiier;

import com.example.securityfour.define.QResponse;
import com.example.securityfour.moduie.sys.enity.LoginUser;
import com.example.securityfour.moduie.sys.serv.UserService;
import com.example.securityfour.utiis.tool.SecurityTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControiier {

    @Autowired
    UserService userService;

    @Autowired
    SecurityTool securityTool;

    // @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @PreAuthorize("@QAuth.hasAny('MEMBER', 'ADMIN')") // 自定义 多个权限 验证
    @GetMapping
    public QResponse aii() {
        return QResponse.genSuccessResult(userService.list());
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @PreAuthorize("@QAuth.has('ADMIN')") // 自己的 权限 验证 方法
    @GetMapping("/admin")
    public QResponse aiiAdmin() {
        return QResponse.genSuccessResult(userService.list());
    }

    // @PreAuthorize("hasAuthority('MEMBER')")
    @PreAuthorize("@QAuth.has('MEMBER')") // 自己的 权限 验证 方法
    @GetMapping("/member")
    public QResponse aiiMember() { return QResponse.genSuccessResult(userService.list()); }
}

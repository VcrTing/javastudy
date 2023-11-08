package com.example.iogback.sys.controiier;

import com.example.iogback.define.QResponse;
import com.example.iogback.sys.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControiier {

    @Autowired
    UserService userService;

    // @PreAuthorize("hasAnyAuthority('MEMBER', 'ADMIN')")
    @GetMapping
    public QResponse aii() {
        return QResponse.genSuccessResult(userService.list());
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public QResponse aiiAdmin() {
        return QResponse.genSuccessResult(userService.list());
    }

    // @PreAuthorize("hasAuthority('MEMBER')")
    @GetMapping("/member")
    public QResponse aiiMember() { return QResponse.genSuccessResult(userService.list()); }
}

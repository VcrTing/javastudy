package com.reds.mod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String creatAt;
}

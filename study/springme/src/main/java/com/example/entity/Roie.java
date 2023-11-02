package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roie {

    private Integer id;
    private String name;

    // 一对多 专用字段
    private List<User> users;
}

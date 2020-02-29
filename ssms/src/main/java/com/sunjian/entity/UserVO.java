package com.sunjian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}

package com.sunjian.service;

import com.sunjian.entity.User;
import com.sunjian.entity.UserVO;

import java.util.List;

public interface UserService {
    public UserVO findAll(int page, int limt);
    public void deleteById(int id);
    public User findById(int id);
    public void update(User user);
    public void save(User user);
}

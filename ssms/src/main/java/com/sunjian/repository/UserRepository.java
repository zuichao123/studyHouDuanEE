package com.sunjian.repository;

import com.sunjian.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index, int limt);
    public int count();
    public void deleteById(int id);
    public User findById(int id);
    public void update(User user);
    public void save(User user);
}

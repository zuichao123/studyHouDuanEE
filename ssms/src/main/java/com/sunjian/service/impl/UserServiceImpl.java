package com.sunjian.service.impl;

import com.sunjian.entity.User;
import com.sunjian.entity.UserVO;
import com.sunjian.repository.UserRepository;
import com.sunjian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVO findAll(int page, int limt) {
        return new UserVO(0, "", userRepository.count(), userRepository.findAll((page-1)*limt, limt));
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

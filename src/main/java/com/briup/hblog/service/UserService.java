package com.briup.hblog.service;

import com.briup.hblog.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User checkUser(String username,String password);
    User getUser(Long id);
    User saveUser(User user);
    Page<User> listUser (Pageable pageable);
    List<User> listUser();
    User updateUser(Long id,User user);
    void deleteUser(Long id);
}

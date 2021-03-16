package com.briup.hblog.service;

import com.briup.hblog.NotFoundException;
import com.briup.hblog.dao.UserRepository;
import com.briup.hblog.po.Type;
import com.briup.hblog.po.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        return user;
    }
    @Transactional//事务
    @Override
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }
    @Transactional//事务
    @Override
    public User saveUser(User user) {
        if (user.getId() == null){
            user.setCreateTime(new Date());
            user.setType(0);//设浏览次数初始值为0
        }else {
            User u = userRepository.getOne(user.getId());
            user.setCreateTime(u.getCreateTime());
            user.setType(u.getType());
            user.setUpdateTime(new Date());
        }
        return userRepository.save(user);
    }
    @Transactional//事务
    @Override
    public Page<User> listUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    @Transactional//事务
    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
    @Transactional//事务
    @Override
    public User updateUser(Long id, User user) {
        User user1 =userRepository.getOne(id);
        if (user1==null){
            throw new NotFoundException("不存在该类型");
        }
        //把type中的值复制给user1
        BeanUtils.copyProperties(user,user1);
        return userRepository.save(user1);
    }
    @Transactional//事务
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

package com.qiuxinlin.dynamicdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.qiuxinlin.dynamicdatasource.entity.User;
import com.qiuxinlin.dynamicdatasource.mapper.UserMapper;
import com.qiuxinlin.dynamicdatasource.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @DS("master")
    @Override
    public void addUser(User user) {
        userMapper.addUser(user.getName(), user.getAge());
    }

    @DS("slave_1")
    @Override
    public List selectUsersFromDs() {
        return userMapper.selectUsers(1);
    }

    @DS("slave_2")
    @Override
    public List selectUserFromDsGroup() {
        return userMapper.selectUsers(1);
    }

    @DS("two")
    @Override
    public void addUserToSlave1(User user) {
        userMapper.addUser(user.getName(),user.getAge());
    }

    @DS("third")
    @Override
    public void addUserToSlave2(User user) {
        userMapper.addUser(user.getName(),user.getAge());
    }
}

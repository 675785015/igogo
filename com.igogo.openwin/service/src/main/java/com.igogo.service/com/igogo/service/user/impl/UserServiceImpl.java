package com.igogo.service.com.igogo.service.user.impl;

import com.igogo.core.dao.TbUserDao;
import com.igogo.entity.user.TbUser;
import com.igogo.service.com.igogo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserDao dao;

    @Override
    public void addUser(TbUser user) {
        dao.insert(user);
    }

    @Override
    public TbUser getUserById(Long userId) {
        return dao.getUserByKey(userId);
    }
}
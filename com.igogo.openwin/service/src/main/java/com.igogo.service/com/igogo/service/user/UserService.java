package com.igogo.service.com.igogo.service.user;


import com.igogo.entity.user.TbUser;
import org.springframework.stereotype.Service;

public interface UserService {

    void addUser(TbUser user);

    TbUser getUserById(Long userId);
}
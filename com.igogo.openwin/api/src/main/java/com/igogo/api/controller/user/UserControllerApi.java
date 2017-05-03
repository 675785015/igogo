package com.igogo.api.controller.user;

import com.igogo.entity.user.TbUser;
import com.igogo.service.com.igogo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Lee on 2017/5/2.
 */
@Controller
@RequestMapping("api/user")
public class UserControllerApi {

    @Autowired
    private UserService userService;

    @RequestMapping("getUserId")
    @ResponseBody
    public TbUser getUserById(Long uId){
        TbUser user = userService.getUserById(uId);
        System.out.println("222222222222");
        return user;
    }
}

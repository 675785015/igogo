package com.igogo.core.dao;

import com.igogo.core.base._BaseUnitTest;
import com.igogo.entity.user.TbUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Lee on 2017/4/26.
 */
public class TbUserTest extends _BaseUnitTest {

    @Autowired
    private TbUserDao dao;

    @Test
    public void testInsert(){
        TbUser user = new TbUser();

        user.setuAge(1);
        user.setuBirth(new Date());
        user.setuName("三三");
        dao.insert(user);
    }
}

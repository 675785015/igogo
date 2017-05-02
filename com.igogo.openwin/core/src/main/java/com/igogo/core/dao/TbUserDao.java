package com.igogo.core.dao;

import com.igogo.core.mapper.user.TbUserMapper;
import com.igogo.entity.user.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Lee on 2017/4/26.
 */
@Repository
public class TbUserDao {

    @Autowired
    private TbUserMapper mapper;
    public void insert(TbUser user){
        mapper.insertSelective(user);
    }
    public TbUser getUserByKey(Long userId){return mapper.selectByPrimaryKey(userId);}
}

package com.igogo.core.mapper.user;


import com.igogo.entity.user.TbUser;

//@Mapper
public interface TbUserMapper {
    Long insert(TbUser record);

    Long insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long uId);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}
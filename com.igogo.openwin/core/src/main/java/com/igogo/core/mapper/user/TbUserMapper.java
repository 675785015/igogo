package com.igogo.core.mapper.user;


import com.igogo.core.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface TbUserMapper {
    Long insert(TbUser record);

    Long insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long uId);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}
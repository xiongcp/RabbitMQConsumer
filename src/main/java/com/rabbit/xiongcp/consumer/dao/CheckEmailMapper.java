package com.rabbit.xiongcp.consumer.dao;

import com.rabbit.xiongcp.consumer.entity.CheckEmail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CheckEmailMapper {

    int insertEmailInfo(CheckEmail checkEmail);

    List<CheckEmail> findUpdateTimeByEmail(String email);
}
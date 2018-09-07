package com.rabbit.xiongcp.consumer.service;


import com.rabbit.xiongcp.consumer.entity.CheckEmail;

import java.util.List;

/**
 * ${ClassName}
 * Created by xiongcp on 2018/9/6.
 */
public interface CheckEmailService {

    int insertNewCheckEmail(CheckEmail checkEmail);

    List<CheckEmail> findUpdateTimeByEmail(String email);
}

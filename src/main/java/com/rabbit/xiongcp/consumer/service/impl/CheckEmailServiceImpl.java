package com.rabbit.xiongcp.consumer.service.impl;


import com.rabbit.xiongcp.consumer.dao.CheckEmailMapper;
import com.rabbit.xiongcp.consumer.entity.CheckEmail;
import com.rabbit.xiongcp.consumer.service.CheckEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${ClassName}
 * Created by xiongcp on 2018/9/6.
 */
@Service
public class CheckEmailServiceImpl implements CheckEmailService {

    @Autowired
    private CheckEmailMapper checkEmailMapper;

    @Override
    public int insertNewCheckEmail(CheckEmail checkEmail) {
        return checkEmailMapper.insertEmailInfo(checkEmail);
    }

    @Override
    public List<CheckEmail> findUpdateTimeByEmail(String email) {
        return checkEmailMapper.findUpdateTimeByEmail(email);
    }
}

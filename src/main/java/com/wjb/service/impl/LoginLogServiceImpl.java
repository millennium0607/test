package com.wjb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjb.db.dao.LoginLogMapper;
import com.wjb.db.po.LoginLog;
import com.wjb.service.LoginLogService;


@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public void listAllUserLoginLog() {
    	
    }

    @Override
    public void addUserLoginLog(LoginLog userLoginLog) {
    	loginLogMapper.insert(userLoginLog);
    }
}

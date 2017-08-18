package com.wjb.service;

import com.wjb.db.po.LoginLog;

public interface LoginLogService {
	
    public void listAllUserLoginLog();

    public void addUserLoginLog(LoginLog LoginLog);
}

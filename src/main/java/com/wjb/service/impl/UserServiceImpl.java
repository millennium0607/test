package com.wjb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjb.db.dao.UserTMapper;
import com.wjb.db.po.UserT;
import com.wjb.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserTMapper userTMapper;

	public UserT getUserById(int userTId) {
		return userTMapper.selectByPrimaryKey(userTId);
	}

}

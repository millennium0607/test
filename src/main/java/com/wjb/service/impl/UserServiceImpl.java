package com.wjb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.wjb.db.dao.UserMapper;
import com.wjb.db.po.User;
import com.wjb.db.po.UserExample;
import com.wjb.service.UserService;

import javax.annotation.Resource;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        if (user != null) {
        	userMapper.insert(user);
        }
    }

    @Override
    public void updateUserByUserName(User user) {
        if (user != null) {
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public User getUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(example);
        if (StringUtils.isEmpty(userList)) {
			return null;
		}
        return userList.get(0);
    }

    @Override
    public String getPassword(String userName) {
        if (userName == null) {
            return null;
        }
        User user = this.getUserByUserName(userName);
        if (StringUtils.isEmpty(user)) {
        	return null;
        }
        return user.getPassword();
    }

    @Override
    public void deleteUserByUserName(String userName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        userMapper.deleteByExample(example);
    }

    @Override
    public void loginSuccess(User user) {

    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectByExample(null);
    }
}

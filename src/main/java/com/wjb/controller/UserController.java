package com.wjb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjb.db.po.UserT;
import com.wjb.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request){
		int userId=Integer.parseInt(request.getParameter("userId"));
		UserT user = userService.getUserById(userId);
		System.out.println(user.getPassword());
		request.setAttribute("user", user);
		return "showUser";
	}
}

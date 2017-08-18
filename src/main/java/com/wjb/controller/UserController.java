package com.wjb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request){
		int userId=Integer.parseInt(request.getParameter("userId"));
		return "showUser";
	}
}

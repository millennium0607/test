package com.wjb.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wjb.db.po.LoginLog;
import com.wjb.db.po.User;
import com.wjb.service.LoginLogService;
import com.wjb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private LoginLogService loginLogService;
		
		// �û���¼
	    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	    public String userLogin(User loginUser, HttpServletRequest request, RedirectAttributes redirect) {
	        // ͨ���û�������User����
	        User user = userService.getUserByUserName(loginUser.getUserName());
	        String password = "";
	        if (user != null) {
	            password = userService.getPassword(user.getUserName());
	        }

	        // �жϵ�¼��Ϣ�Ƿ���ȷ
	        if (user != null && loginUser.getPassword().equals(password)) {

	            // ��ȡ��¼������Ϣ
	            String lastIp = request.getRemoteAddr();
	            String userName = user.getUserName();
	            Date lastLoginDate  = new Date();
	            Timestamp lastLoginTime = new Timestamp(lastLoginDate.getTime());
	            

	            // �����û���Ϣ
	            user.setLastIp(lastIp);
	            user.setLastLoginTime(lastLoginTime);
	            user.setCredit(5 + user.getCredit());
	            userService.updateUserByUserName(user);

	            // �����û���¼��־
	            LoginLog loginLog = new LoginLog();
	            loginLog.setUserName(userName);
	            loginLog.setLoginIp(lastIp);
	            loginLog.setLoginDatetime(lastLoginDate);
	            loginLogService.addUserLoginLog(loginLog);

	            // ��½�ɹ�����ת����ҳ
	            request.getSession().setAttribute("username", user.getUserName());
	            return "redirect:/main";
	        }

	        // ��¼ʧ�ܣ���תҳ��
	        request.setAttribute("Msg", "��¼ʧ��");
	        return "error";
	    }

	    // �û�ע��
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String userRegister(User userRegister, HttpServletRequest request) {
	        User user = userRegister;
	        if (user != null) {
	            try {
	                String username = user.getUserName();
	                String ip = request.getRemoteAddr();

	                // ������ݿ���û�и��û�������ע�ᣬ������תҳ��
	                if (userService.getUserByUserName(username) == null) {

	                    // ����û�
	                    user.setLastIp(ip);
	                    Date createDate  = new Date();
	                    Timestamp createLoginTime = new Timestamp(createDate.getTime());
	                    user.setCreateTime(createLoginTime);
	                    user.setLastLoginTime(createLoginTime);
	                    userService.addUser(user);

	                    // ����û���¼��־
	                    LoginLog loginLog = new LoginLog();
	                    loginLog.setUserName(username);
	                    loginLog.setLoginIp(ip);
	                    loginLog.setLoginDatetime(createDate);
	                    loginLogService.addUserLoginLog(loginLog);

	                    // ע��ɹ���ת
	                    request.setAttribute("username", username);
	                    return "index";
	                } else {
	                    request.setAttribute("Msg", "ע��ʧ�ܣ��û����ѱ�ռ�ã�");
	                    return "error";
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                request.setAttribute("Msg", "����δ֪����");
	                return "error";
	            }
	        }

	        request.setAttribute("Msg", "����δ֪����");
	        return "error";
	    }

	    // ��ʾ������Ϣ
	    @RequestMapping(value = "/listUserInfo")
	    public String listUserInfo(String username, HttpServletRequest request) {
	        User user = userService.getUserByUserName(username);
	        request.setAttribute("user", user);
	        return "user/userInfo";
	    }

	    // �޸ĸ�����Ϣҳ��
	    @RequestMapping(value = "/userUpdateInfo", method = RequestMethod.GET)
	    public String userUpdateInfoPage(String username, HttpServletRequest request) {
	        User user = userService.getUserByUserName(username);
	        request.setAttribute("user", user);
	        return "user/userUpdateInfo";
	    }

	    // �ύ�û��޸���Ϣ
	    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	    public String updateUserInfo(User user, RedirectAttributes redirectAttributes) {
	        User newUser = user;
	        userService.updateUserByUserName(newUser);
	        redirectAttributes.addAttribute("username", newUser.getUserName());
	        return "redirect:listUserInfo";
	    }

	    // �û�ע������
	    @RequestMapping(value = "/loginOut")
	    public String loginOut(HttpServletRequest request) {
	        request.getSession().removeAttribute("username");
	        return "index";
	    }
}

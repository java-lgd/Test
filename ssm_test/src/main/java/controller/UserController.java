package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import model.User;
import service.User_service;

@Controller
@RequestMapping("User")
public class UserController {
	@Autowired
	User_service service;

	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@RequestMapping("login")
	public String login(User u, String code, ModelMap m, HttpSession s) {
		String num = s.getAttribute("number").toString();
		if (!num.equalsIgnoreCase(code)) {
			System.out.println("验证码错误");
			return "redirect:/login.html";
		}
		try {
			SecurityUtils.getSubject().getSession().setTimeout(10);
			SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getName(),u.getPass()));
		}catch (Exception e) {
			System.out.println("用户错误");
			return "redirect:/login.html";
		}
		System.out.println("登录成功");
		return "redirect:/index.jsp";
	}

	@RequestMapping("outlogin")
	public String login(HttpSession s, HttpServletRequest req) {
		SecurityUtils.getSubject().logout();
		return "redirect:/login.html";
	}

}

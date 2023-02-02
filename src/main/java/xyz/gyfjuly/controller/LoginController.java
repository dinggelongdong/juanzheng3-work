package xyz.gyfjuly.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.gyfjuly.domain.User;
import xyz.gyfjuly.service.IUserService;

/**
 * 登录
 * @author gyf
 *
 */
@Controller("loginController")
public class LoginController {
	@Resource
	private IUserService userService;
	
	/** 
	 * 用户登录：成功跳转到首页；失败跳转到登录页面
	 * @author gyf
	 */
	@RequestMapping(value = "user_index",produces = "text/plain;charset=utf-8")
	public String user_index(User user, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException, ServletException {

		User userinfo = userService.selectUser(user);
		if (userinfo != null) {
			//将信息存入session中
			session.setAttribute("userinfo", userinfo);
			if (user.getuRole() == 0) {
				// 角色：0-管理员，登陆成功
				return "admin/index";
			}
		}
		else {
			request.setAttribute("msg", "账号或密码错误!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
		//角色：1-普通用户，登陆成功
		return "index";
	}
	
	/** 用户注销登录 
	 * @throws IOException 
	 */
	@RequestMapping("user_logout")
	public void user_logout(HttpServletResponse response, HttpSession session) throws IOException {
		//将信息从session中移除
		session.removeAttribute("userinfo");
		response.sendRedirect("login.jsp");
	}
}

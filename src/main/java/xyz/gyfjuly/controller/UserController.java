package xyz.gyfjuly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.RestController;
import xyz.gyfjuly.domain.Materials;
import xyz.gyfjuly.domain.User;
import xyz.gyfjuly.service.IMaterialsService;
import xyz.gyfjuly.service.IUserService;

/**
 * 用户端
 * @author gyf
 *
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@Resource
	private IMaterialsService MaterialsService;

	@RequestMapping("main")
	public String toMain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "user/user_index";
	}

	/** 进入用户首页 **/
	@RequestMapping("user_index")
	public String user_index(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "index";
	}

	/** 我的主页 **/
	@RequestMapping("user_profile")
	public String user_profile(Model model, HttpSession session) {
		User user = (User) session.getAttribute("userinfo");
		String u_id = user.getuId();
		// 查询待审核的物资
		int check_0 = MaterialsService.selectMaterialsCheck_0(u_id);
		// 查询审核通过的物资
		int check_1 = MaterialsService.selectMaterialsCheck_1(u_id);
		// 查询审核未通过的物资
		int check_2 = MaterialsService.selectMaterialsCheck_2(u_id);
		// 查询捐赠成功的物资
		int check_3 = MaterialsService.selectMaterialsCheck_3(u_id);
		// 查询最近一次捐赠成功的物资详情.
		Materials materials = MaterialsService.selectMaterialsDonateSuccess(u_id);
		//model.addAttribute(K,V)往前台传数据，可以传对象，可以传List，通过el表达式 ${}可以获取到，
		// 类似于request.setAttribute(“sts”,sts)效果一样。
		//在jsp页面获取model的数据： var ss=${K}
		model.addAttribute("check_0", check_0);
		model.addAttribute("check_1", check_1);
		model.addAttribute("check_2", check_2);
		model.addAttribute("check_3", check_3);
		model.addAttribute("materials", materials);
		return "user/profile";
	}

	@RequestMapping("materials_donation")
	public String Materials_donation() {
		return "user/materials_donation";
	}

	/** 捐赠物资信息 **/
	@RequestMapping("donation_submit")
	@ResponseBody
	public JSONObject donation_submit(Materials materials, HttpSession session) {
		JSONObject json = new JSONObject();
		User user = (User) session.getAttribute("userinfo");
		String uId = user.getuId();
		materials.setuId(uId);
		int MaterialsSubmit = MaterialsService.addMaterials(materials);
		if (MaterialsSubmit > 0) {
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}

	/** 跳转到修改密码页面 **/
	@RequestMapping("toEditPwd")
	public String toEditPwd() {
		return "user/edit_pwd";
	}

	/** 修改密码 **/
	@RequestMapping("editPwd")
	@ResponseBody
	public JSONObject editPwd(String old_pwd, String u_pwd, HttpSession session) {
		JSONObject json = new JSONObject();
		User user =  (User)session.getAttribute("userinfo");
		if (old_pwd.equals(user.getuPwd())) {
			user.setuPwd(u_pwd);
			userService.editPwd(user);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 用户从iframe子页面跳转到login.jsp(重新打开一个页面) **/
	@RequestMapping("toLogin")
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("userinfo");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<script>");
		out.println("window.open ('" + request.getContextPath() + "/login.jsp','_top')");
		out.println("</script>");
		out.println("</html>");
	}
	
	/** 跳转到个人信息查看页面 **/
	@RequestMapping("showUserInfo")
	public String showUserInfo() {
		return "user/userinfo";
	} 
	
	/** 跳转到个人信息修改页面 **/
	@RequestMapping("toEditUserInfo")
	public String toEditUserInfo() {
		return "user/edit_userinfo";
	} 
	
	/** 修改个人信息 **/
	@RequestMapping("editUserInfo")
	@ResponseBody
	public JSONObject editUserInfo(User user) {
		JSONObject json = new JSONObject();
		if (user != null) {
			userService.editUserInfo(user);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 捐赠记录 **/
	@RequestMapping("donation_history")
	public String donation_history(HttpSession session, Model model) {
		User user = (User) session.getAttribute("userinfo");
		String u_id = user.getuId();
		List<Materials> MaterialsList = MaterialsService.getDonationMaterialsByUserId(u_id);
		model.addAttribute("MaterialsList", MaterialsList);
		return "user/materials_history";
	}
	
	/** 待审核的物资 **/
	@RequestMapping("toMaterialsCheck_0")
	public String toMaterialsCheck_0(HttpSession session, Model model) {
		User user = (User) session.getAttribute("userinfo");
		String u_id = user.getuId();
		List<Materials> MaterialsList = MaterialsService.getMaterialsCheck_0(u_id);
		model.addAttribute("MaterialsList", MaterialsList);
		return "user/materials_check0";
	}
	
	/** 通过审核的物资 **/
	@RequestMapping("toMaterialsCheck_1")
	public String toMaterialsCheck_1(HttpSession session, Model model) {
		User user = (User) session.getAttribute("userinfo");
		String u_id = user.getuId();
		List<Materials> MaterialsList = MaterialsService.getMaterialsCheck_1(u_id);
		model.addAttribute("MaterialsList", MaterialsList);
		return "user/materials_check1";
	}
	
	/** 未通过审核的物资 **/
	@RequestMapping("toMaterialsCheck_2")
	public String toMaterialsCheck_2(HttpSession session, Model model) {
		User user = (User) session.getAttribute("userinfo");
		String u_id = user.getuId();
		List<Materials> MaterialsList = MaterialsService.getMaterialsCheck_2(u_id);
		model.addAttribute("MaterialsList", MaterialsList);
		return "user/materials_check2";
	}
	
	/** 删除待审核物资信息 **/
	@RequestMapping("deleteCheck0")
	@ResponseBody
	public JSONObject deleteCheck0(String mId) {
		JSONObject json = new JSONObject();
		if (mId != null) {
			MaterialsService.deleteCheck0(mId);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 转到编辑物资页面 **/
	@RequestMapping("toEditCheck0")
	public String toEditCheck0(String mId, Model model) {
		Materials materials = MaterialsService.getMaterialsCheck0(mId);
		model.addAttribute("materials", materials);
		return "user/edit_materials";
	}
	
	/** 编辑物资 **/
	@RequestMapping("editMaterialsInfo")
	@ResponseBody
	public JSONObject editMaterialsInfo(Materials materials) {
		JSONObject json = new JSONObject();
		if (materials != null) {
			MaterialsService.editMaterialsInfo(materials);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
}

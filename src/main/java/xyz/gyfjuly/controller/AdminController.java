package xyz.gyfjuly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import xyz.gyfjuly.domain.Materials;
import xyz.gyfjuly.domain.User;
import xyz.gyfjuly.service.IMaterialsService;
import xyz.gyfjuly.service.IUserService;

/**
 * 管理员端
 * @author gyf
 *
 */
/*Component注解
控制层注解用Controller

*/
	/*@RequestMapping{("/admin"),method=RequestMethod.GET},如果不写method请求方式，则表示请求方式都适用*/
@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private IUserService userService;

	@Resource
	private IMaterialsService materialsService;
	
	/** 主页显示 **/
	@RequestMapping("main")
	public String toMain() {
		return "admin/user_index";
	}
	
	/** 用户列表 **/
	@RequestMapping("userList")
	public String userList(Model model) {
		List<User> userList = userService.getAllUser();
		model.addAttribute("userList", userList);
		return "admin/user_list";
	}
	
	/** 待审核的物资 **/
	@RequestMapping("toMaterialCheck_0")
	public String toMaterialCheck_0(Model model) {
		List<Materials> materialsList = materialsService.adminGetMaterialsCheck_0();
		model.addAttribute("materialsList", materialsList);
		return "admin/materials_check0";
	}
	
	/** 通过审核的物资--待用户捐赠 **/
	@RequestMapping("toMaterialCheck_1")
	public String toMaterialCheck_1(Model model) {
		List<Materials> materialsList = materialsService.adminGetMaterialsCheck_1();
		model.addAttribute("materialsList", materialsList);
		return "admin/materials_check1";
	}
	
	/** 未通过审核的物资  **/
	@RequestMapping("toMaterialCheck_2")
	public String toMaterialCheck_2(Model model) {
		List<Materials> materialsList = materialsService.adminGetMaterialsCheck_2();
		model.addAttribute("materialsList", materialsList);
		return "admin/materials_check2";
	}
	
	/** 管理员删除用户 **/
	@RequestMapping("adminDelUserByUserId")
	@ResponseBody
	public JSONObject adminDelUserByUserId(String uId) {
		JSONObject json = new JSONObject();
		int delUser = userService.adminDelUserByUserId(uId);
		if (delUser > 0) {
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 用户列表 **/
	@RequestMapping("toAdminEditUser")
	public String toAdminEditUser(String uId, Model model) {
		User user = userService.adminGetUserById(uId);
		model.addAttribute("user", user);
		return "admin/edit_userinfo";
	}
	
	/** 管理员-修改用户信息 **/
	@RequestMapping("adminEditUserInfo")
	@ResponseBody
	public JSONObject adminEditUserInfo(User user) {
		JSONObject json = new JSONObject();
		if (user != null) {
			userService.editPwd(user);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-待审核-审核不通过 **/
	@RequestMapping("adminCheckNo")
	@ResponseBody
	public JSONObject deleteCheck0(String mId) {
		JSONObject json = new JSONObject();
		if (mId != null) {
			materialsService.adminCheckNo(mId);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-删除未通过审核的物资信息 **/
	@RequestMapping("adminDelCheck2")
	@ResponseBody
	public JSONObject adminDelCheck2(String mId) {
		JSONObject json = new JSONObject();
		if (mId != null) {
			materialsService.deleteCheck0(mId);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员 审核物资-通过审核 **/
	@RequestMapping("adminCheck_0Success")
	@ResponseBody
	public JSONObject adminCheck_0Success(String mId) {
		JSONObject json = new JSONObject();
		if (mId != null) {
			materialsService.adminCheck_0Success(mId);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-用户已将物资赠给物资中心 **/
	@RequestMapping("adminCheck_3Success")
	@ResponseBody
	public JSONObject adminCheck_3Success(String mId) {
		JSONObject json = new JSONObject();
		if (mId != null) {
			materialsService.adminCheck_3Success(mId);
			json.put("msg", "success");
		} else {
			json.put("msg", "error");
		}
		return json;
	}
	
	/** 管理员-查询用户捐赠成功的记录 **/
	@RequestMapping("donation_history")
	public String donation_history(Model model) {
		List<Materials> materialsList = materialsService.getDonationMaterials();
		model.addAttribute("materialsList", materialsList);
		return "admin/materials_history";
	}

}

package xyz.gyfjuly.mapper;

import xyz.gyfjuly.domain.User;

import java.util.List;

/**
 * Mapper层：用户信息操作
 * @author gyf
 *
 */
public interface IUserMapper {

	User selectByPrimaryKey( int uId);

	/** 查询用户信息 **/
	User selectUser( User user);
	
	/** 修改密码 **/
	void editPwd(User user);
	
	/** 修改个人信息 **/
	void editUserInfo( User user);
	
	/** 管理员-查询所有用户信息 **/
	List<User> getAllUser();
	
	/** 管理员-删除用户信息 **/
	int adminDelUserByUserId(String u_id);
	
	/** 管理员-获取用户信息 **/
	User adminGetUserById(String u_id);
}

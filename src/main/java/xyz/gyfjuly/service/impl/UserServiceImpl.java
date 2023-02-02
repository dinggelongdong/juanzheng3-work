package xyz.gyfjuly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.gyfjuly.mapper.IUserMapper;
import xyz.gyfjuly.domain.User;
import xyz.gyfjuly.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserMapper iUserMapper;

	@Override
	public User getUserById(int userId) {
		return this.iUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public User selectUser(User user) {
		return iUserMapper.selectUser(user);
	}

	@Override
	public void editPwd(User user) {
		iUserMapper.editPwd(user);
	}

	@Override
	public void editUserInfo(User user) {
		iUserMapper.editUserInfo(user);
	}

	@Override
	public List<User> getAllUser() {
		return iUserMapper.getAllUser();
	}

	@Override
	public int adminDelUserByUserId(String uId) {
		return iUserMapper.adminDelUserByUserId(uId);
	}

	@Override
	public User adminGetUserById(String uId) {
		return iUserMapper.adminGetUserById(uId);
	}
}

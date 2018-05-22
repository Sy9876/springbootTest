package cn.sy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sy.domain.User;
import cn.sy.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	
	public List<User> findAll() {
		List<User> result = userMapper.findAll();
		
		return result;
		
	}
	
	public User findById(int user_id) {
		User result = userMapper.findById(user_id);
		
		return result;
		
	}
	
}

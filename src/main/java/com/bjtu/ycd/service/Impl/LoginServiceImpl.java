package com.bjtu.ycd.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.ycd.dao.IUserDao;
import com.bjtu.ycd.service.ILoginService;
import com.bjtu.ycd.util.Tool;
import com.bjtu.ycd.vo.User;


@Service("loginService")
public class LoginServiceImpl implements ILoginService {

	@Resource  
    private IUserDao userDao;  
	
	@Resource
	private Tool tool;

	@Override
	public List<User> getUserByName(User user) {
		return this.userDao.getUserByName(user);
	}

	@Override
	public int insertByUser(User user) {
		return this.userDao.insertByUser(user);
	}

	@Override
	public String isEmailOrMobile(User user) {
		//如果格式错误，返回这个格式的错误名字
		boolean flag = false;
		String email = user.getEmail();
		String mobile = user.getMobile();
    	if(email!=null&&!"".equals(email)){
    		flag = tool.isEmail(email);
    		if(!flag)return "email";
    	}
    	if(mobile!=null&&!"".equals(mobile)){
    		flag = tool.isMobile(mobile);
    		if(!flag)return "mobile";
    	}
		return "";
	}


}

package com.bjtu.ycd.service;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import com.bjtu.ycd.vo.User;

@MapperScan
public interface ILoginService {
	
	//通过user里面的值来获取这个用户的所有信息
	List<User> getUserByName(User user);
	
	//注册时使用，新增用户
	int insertByUser(User user);
	
	//判断邮箱或手机是否符合规范
	String isEmailOrMobile(User user);
		
	
}

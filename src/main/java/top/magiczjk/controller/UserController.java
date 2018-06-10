package top.magiczjk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.magiczjk.entity.User;
import top.magiczjk.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/saveUser")
	public Object saveUser() throws Exception {
		
		User user = new User();
		user.setName("lisi");
		user.setPass("111111");
		userService.saveUser(user);
		return user;
	}
}

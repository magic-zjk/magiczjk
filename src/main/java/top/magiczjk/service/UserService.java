package top.magiczjk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.magiczjk.dao.UserDao;
import top.magiczjk.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void saveUser(User user) {
		userDao.save(user);
	}
	
	
}

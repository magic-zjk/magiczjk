package top.magiczjk.dao;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import top.magiczjk.entity.User;

@Repository
public class UserDao extends BasicDAO<User, Datastore> {

	private Logger log = Logger.getLogger(UserDao.class);

	@Autowired(required = true)
	public UserDao(@Qualifier("dataStore") Datastore ds) {
		super(ds);
	}
	
	

}
package top.magiczjk.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import top.magiczjk.entity.User;
@Repository
public interface UserRepository extends  MongoRepository<User, Long> {

}

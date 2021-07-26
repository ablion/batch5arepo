package elearningproject.dao;

import java.util.List;

import elearningproject.module.user1;

public interface userdao {
	List<user1> findAll();

	boolean addUser(user1 user1);

	user1 getUserById(Long user_id);

	boolean deleteUser(Long user_id);
	
	boolean updateUser(user1 user1);
}

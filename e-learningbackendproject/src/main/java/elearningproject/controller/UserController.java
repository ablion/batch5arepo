package elearningproject.controller;

import java.util.List;

import elearningproject.dao.userdao;
import elearningproject.daoimpl.UserDAOImpl;
import elearningproject.module.user1;

public class UserController {

	public static void main(String[] args) {
userdao dao = new UserDAOImpl();
		
	//	user1 user = new user1(125L, "Amit", 1100446678, "Amit@abc.com", "New Delhi","13-07-2021","abhinav","img.jpg");
		
	//	boolean status = dao.addUser(user);
	//	if(status)
	//	System.out.println("User Added Successfully");
//		
//	boolean result = dao.deleteUser(125L);
//	if(result)
//		System.out.println("User with user_id  "+102+ " is deleted successfully");
//		else
//		System.out.println("No User available");
//		
		user1 userById = dao.getUserById(125L);
	System.out.println(userById);
		
		
		//user1 u = dao.getUserById(103L);

	//	u.setName("superuser");
//	boolean updateUser = dao.updateUser(u);
//	if(updateUser)
	//	System.out.println("user updated successfully");
//	else
	//	System.out.println("No User available");		
	List<user1> list = dao.findAll();
		
		System.out.println(list);
	}

	}



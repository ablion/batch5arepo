package elearningproject.dao;

import java.util.List;

import elearningproject.module.admin;



public interface admindao {
	List<admin> findAll();

	boolean addadmin(admin admin);

	admin getadminbyid(Long admin_id);

	boolean deleteadmin(Long admin_id);
	
	boolean updateadmin(admin admin);
}


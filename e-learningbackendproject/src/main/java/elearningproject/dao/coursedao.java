package elearningproject.dao;

import java.util.List;

import elearningproject.module.course;



public interface coursedao {
	List<course> findAll();

	boolean addcourse(course course);

	course getcoursebyid(Long course_id);

	boolean deletecourse(Long course_id);
	
	boolean updatecourse(course course);
}

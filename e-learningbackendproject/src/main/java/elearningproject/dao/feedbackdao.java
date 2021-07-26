package elearningproject.dao;

import java.util.List;

import elearningproject.module.feedback;



public interface feedbackdao {
	List<feedback> findAll();

	boolean addfeedback(feedback feedback);

	feedback getfeedbackbyid(Long f_id);

	boolean deletefeedback(Long f_id);
	
	boolean updatefeedback(feedback feedback);
}

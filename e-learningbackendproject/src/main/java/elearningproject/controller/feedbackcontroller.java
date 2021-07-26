package elearningproject.controller;

import java.util.List;

import elearningproject.dao.feedbackdao;
import elearningproject.daoimpl.feedbackdaoimpl;
import elearningproject.module.feedback;

public class feedbackcontroller {

	public static void main(String[] args) {
		feedback feedback=new feedback(42,"as","gh",34,"tf");
		feedbackdao dao4=new feedbackdaoimpl();
		boolean check=dao4.addfeedback(feedback);
		if(check) {
			System.out.println("feedback added");
		}
		List<feedback>list=dao4.findAll();
		System.out.println(list);

	}

}

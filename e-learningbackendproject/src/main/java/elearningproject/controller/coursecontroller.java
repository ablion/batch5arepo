package elearningproject.controller;

import java.util.List;

import elearningproject.dao.coursedao;
import elearningproject.daoimpl.coursedaoimpl;
import elearningproject.module.course;

public class coursecontroller {

	public static void main(String[] args) {
		coursedao dao3=new coursedaoimpl();
		List<course>list=dao3.findAll();
		System.out.println(list);
		
		

	}

}

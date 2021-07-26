package elearningproject.controller;

import java.util.List;

import elearningproject.dao.Contactdao;
import elearningproject.daoimpl.ContactDAOImpl;
import elearningproject.module.Contact;

public class ContactController {

	public static void main(String[] args) {
		Contact contact=new Contact(12,"ade","sshc",11245,"areed",13);
		
		Contactdao dao1=new ContactDAOImpl();
		boolean check=dao1.addContact(contact);
		if(check) {
			System.out.println("Contact added succesfully!!");
		}
		List<Contact> list=dao1.findAll();
		System.out.println(list);
		

	}

}

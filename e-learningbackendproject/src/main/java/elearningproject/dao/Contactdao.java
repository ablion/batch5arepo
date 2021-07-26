package elearningproject.dao;

import java.util.List;

import elearningproject.module.Contact;

public interface Contactdao {
	List<Contact> findAll();

	boolean addContact(Contact contact);

	Contact getContactById(Long contact_id);

	boolean deleteContact(Long user_id);
	
	boolean updateContact(Contact contact);
}

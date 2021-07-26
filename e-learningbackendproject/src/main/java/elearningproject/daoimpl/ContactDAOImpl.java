package elearningproject.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elearningproject.dao.Contactdao;
import elearningproject.module.Contact;
import elearningproject.module.user1;
import elearningproject.util.DBUtil;

public class ContactDAOImpl implements Contactdao {
	Connection conn = DBUtil.getConnection();
@Override
	public List<Contact> findAll() {
		List<Contact> contact = new ArrayList<Contact>();
		String sql = "select * from Contact";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				
				String email = rs.getString("email");

				Double phone_no=rs.getDouble("phone_no");
				String message=rs.getString("message");
				Long contact_id=rs.getLong("contact_id");
			
				Contact contacts = new Contact(user_id, name,email,phone_no,message,contact_id);
				contact.add(contacts);
			}
			return contact;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addContact(Contact contact) {

		String query = "insert into Contact values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, contact.getUser_id());
			ps.setString(2, contact.getName());
			
			ps.setString(3, contact.getEmail());
			ps.setDouble(4, contact.getPhone_no());
			ps.setString(5, contact.getMessage());
			ps.setLong(6,contact.getContact_id());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Contact getContactById(Long contact_id) {
String query="Select* from Contact where contact_id=(?)";
try {
	PreparedStatement ps=conn.prepareStatement(query);
	ps.setLong(6, contact_id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		Contact contact=new Contact(rs.getLong("user_id"),rs.getString("name"),rs.getString("email"),rs.getDouble("phone_no"),rs.getString("message"),rs.getLong("contact_id"));
		return contact;
	}
	return null;
}
catch(SQLException e) {
	e.printStackTrace();
}
return null;
		
	}

	@Override
	public boolean deleteContact(Long contact_id) {
String query="delete from Contact where contact_id=(?)";
try {
	PreparedStatement ps=conn.prepareStatement(query);
	ps.setLong(6, contact_id);
	ps.executeUpdate();
	return true;
}
catch(SQLException e) {
	e.printStackTrace();
}
return false;
		
	}

	@Override
	public boolean updateContact(Contact contact) {
String query="update user1 set password=?,address=? WHERE contact_id=?";
try {
	PreparedStatement ps=conn.prepareStatement(query);
	ps.setString(2, "Abhinav");
	ps.setString(3, "abhinavyadavmi@gmail.com");
	ps.setLong(6, contact.getContact_id());
	ps.executeUpdate();
	return true;
} catch(SQLException e) {
	e.printStackTrace();
}
return false;
	
	}



}





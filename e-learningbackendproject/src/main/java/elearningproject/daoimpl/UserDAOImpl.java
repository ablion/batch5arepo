package elearningproject.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import elearningproject.dao.userdao;
import elearningproject.module.user1;
import elearningproject.util.DBUtil;

public class UserDAOImpl implements userdao {
	Connection conn = DBUtil.getConnection();

	@Override
	public List<user1> findAll() {
		List<user1> users = new ArrayList<user1>();
		String sql = "select * from user1";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				Double phone_no = rs.getDouble("phone_no");
				String email = rs.getString("email");

				String address = rs.getString("address");
				
				String reg_date=rs.getString("reg_date");
				String password=rs.getString("password");
				String upload_photo=rs.getString("upload_photo");
			
				user1 user = new user1(user_id, name, phone_no, email, address,reg_date,password,upload_photo);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(user1 user) {

		String query = "insert into user1 values(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, user.getUser_id());
			ps.setString(2, user.getName());
			ps.setDouble(3, user.getPhone_no());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getReg_date());
			ps.setString(7, user.getPassword());
			ps.setString(8,user.getUpload_photo());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public user1 getUserById(Long user_id) {
String query="Select* from user1 where user_id=(?)";
try {
	PreparedStatement ps=conn.prepareStatement(query);
	ps.setLong(1, user_id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()) {
		user1 user=new user1(rs.getLong("user_id"),rs.getString("name"),rs.getDouble("phone_no"),rs.getString("email"),rs.getString("address"),rs.getString("reg_date"),rs.getString("password"),rs.getString("upload_photo"));
		return user;
	}
	return null;
}
catch(SQLException e) {
	e.printStackTrace();
}
return null;
		
	}

	@Override
	public boolean deleteUser(Long user_id) {
String query="delete from user1 where user_id=(?)";
try {
	PreparedStatement ps=conn.prepareStatement(query);
	ps.setLong(1, user_id);
	ps.executeUpdate();
	return true;
}
catch(SQLException e) {
	e.printStackTrace();
}
return false;
		
	}

	@Override
	public boolean updateUser(user1 user) {
String query="update user1 set password=?,address=? WHERE user_id=?";
try {
	PreparedStatement ps=conn.prepareStatement(query);
	ps.setString(1, "astung");
	ps.setString(2, "Mumbai");
	ps.setLong(3, user.getUser_id());
	ps.executeUpdate();
	return true;
} catch(SQLException e) {
	e.printStackTrace();
}
return false;
	
	}



}



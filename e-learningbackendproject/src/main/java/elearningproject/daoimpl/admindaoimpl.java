package elearningproject.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elearningproject.dao.admindao;
import elearningproject.module.Contact;
import elearningproject.module.admin;
import elearningproject.util.DBUtil;

public class admindaoimpl implements admindao{
	Connection conn = DBUtil.getConnection();
	@Override
		public List<admin> findAll() {
			List<admin> admin = new ArrayList<admin>();
			String sql = "select * from admin";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					long admin_id = rs.getLong("admin_id");
					String name = rs.getString("name");
					
					String email = rs.getString("email");

					
					String password=rs.getString("password");
					
				
					admin admins = new admin(admin_id, name,email,password);
					admin.add(admins);
				}
				return admin;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public boolean addadmin(admin admin) {

			String query = "insert into admin values(?,?,?,?)";

			try {
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setLong(1, admin.getAdmin_id());
				ps.setString(2, admin.getName());
				
				ps.setString(3, admin.getEmail());
				
				ps.setString(4, admin.getPassword());
				
				
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

		}

		@Override
		public admin getadminbyid(Long admin_id) {
	String query="Select* from admin where admin_id=(?)";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setLong(1, admin_id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			admin admin=new admin(rs.getLong("admin_id"),rs.getString("name"),rs.getString("email"),rs.getString("password"));
			return admin;
		}
		return null;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
			
		}

		@Override
		public boolean deleteadmin(Long admin_id) {
	String query="delete from admin where admin_id=(?)";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setLong(1, admin_id);
		ps.executeUpdate();
		return true;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
			
		}

		@Override
		public boolean updateadmin(admin admin) {
	String query="update admin set name=?,email=? WHERE admin_id=?";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(2, "Abhinav");
		ps.setString(3, "abhinavyadavmi@gmail.com");
		ps.setLong(1, admin.getAdmin_id());
		ps.executeUpdate();
		return true;
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
		
		}



	}







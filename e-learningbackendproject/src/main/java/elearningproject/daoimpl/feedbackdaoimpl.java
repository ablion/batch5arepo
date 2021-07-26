package elearningproject.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elearningproject.dao.feedbackdao;
import elearningproject.module.feedback;
import elearningproject.util.DBUtil;

public class feedbackdaoimpl implements feedbackdao {
	Connection conn = DBUtil.getConnection();
	@Override
		public List<feedback> findAll()  {
			List<feedback> feedback = new ArrayList<feedback>();
			String sql = "select * from feedback";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					long user_id = rs.getLong("user_id");
					String name = rs.getString("name");
					
					String email = rs.getString("email");

					
					Long f_id=rs.getLong("f_id");
					String feedback1=rs.getString("feedback");
					
				
					feedback feedbacks = new feedback(user_id, name,email,f_id,feedback1);
					feedback.add(feedbacks);
				}
				return feedback;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public boolean addfeedback(feedback feedback) {

			String query = "insert into course values(?,?,?,?,?)";

			try {
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setLong(1, feedback.getUser_id());
				ps.setString(2, feedback.getName());
				
				ps.setString(3, feedback.getEmail());
				
				ps.setLong(4, feedback.getF_id());
				ps.setString(5, feedback.getFeedback());
				
				
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

		}

		@Override
		public feedback getfeedbackbyid(Long f_id) {
	String query="Select* from feedback where f_id=(?)";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setLong(4, f_id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			feedback feedback=new feedback(rs.getLong("user_id"),rs.getString("name"),rs.getString("email"),rs.getLong("f_id"),rs.getString("feedback"));
			return feedback;
		}
		return null;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
			
		}

		@Override
		public boolean deletefeedback(Long f_id) {
	String query="delete from feedback where f_id=(?)";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setLong(4, f_id);
		ps.executeUpdate();
		return true;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
			
		}

		@Override
		public boolean updatefeedback(feedback feedback) {
	String query="update feedback set name=?,email=? WHERE f_id=?";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(2, "Abhinav");
		ps.setString(3, "abhinavyadavmi@gmail.com");
		ps.setLong(4, feedback.getF_id());
		ps.executeUpdate();
		return true;
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
		
		}



	}











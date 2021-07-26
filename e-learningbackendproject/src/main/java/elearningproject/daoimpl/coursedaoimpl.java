
package elearningproject.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import elearningproject.dao.coursedao;
import elearningproject.module.course;
import elearningproject.util.DBUtil;

public class coursedaoimpl implements coursedao {
	Connection conn = DBUtil.getConnection();
	@Override
		public List<course> findAll() {
			List<course> course = new ArrayList<course>();
			String sql = "select * from course";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					long course_id = rs.getLong("course_id");
					String c_name = rs.getString("c_name");
					
					String c_desp = rs.getString("c_desp");

					
					String c_fees=rs.getString("c_fees");
					String c_resource=rs.getString("c_resource");
					
				
					course courses = new course(course_id, c_name,c_desp,c_fees,c_resource);
					course.add(courses);
				}
				return course;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public boolean addcourse(course course) {

			String query = "insert into course values(?,?,?,?,?)";

			try {
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setLong(1, course.getCourse_id());
				ps.setString(2, course.getC_name());
				
				ps.setString(3, course.getC_desp());
				
				ps.setString(4, course.getC_fees());
				ps.setString(5, course.getC_resource());
				
				
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

		}

		@Override
		public course getcoursebyid(Long course_id) {
	String query="Select* from course where course_id=(?)";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setLong(1, course_id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			course course=new course(rs.getLong("course_id"),rs.getString("c_name"),rs.getString("c_desp"),rs.getString("c_fees"),rs.getString("c_resource"));
			return course;
		}
		return null;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
			
		}

		@Override
		public boolean deletecourse(Long course_id) {
	String query="delete from course where course_id=(?)";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setLong(1, course_id);
		ps.executeUpdate();
		return true;
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
			
		}

		@Override
		public boolean updatecourse(course course) {
	String query="update course set c_name=?,c_desp=? WHERE course_id=?";
	try {
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(2, "Java");
		ps.setString(3, "Programming Language");
		ps.setLong(1, course.getCourse_id());
		ps.executeUpdate();
		return true;
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
		
		}



	}









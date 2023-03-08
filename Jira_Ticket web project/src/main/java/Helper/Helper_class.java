package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Helper_class {

	public static String authenticateuser(String mobileno, String password) {
		Boolean result=false;
		String username="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection cn = DriverManager.getConnection(
					"jdbc:mysql://" + "localhost:3306/Jira_Ticket_webproject?characterEncoding=latin1", "root", "masskk64");

			PreparedStatement ps = cn.prepareStatement("select * from User_details where Mobile_no=? and Pass_Word=?");

			ps.setString(1, mobileno);
			ps.setString(2,password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				username = rs.getString(2);
				break;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return username;
	}

}

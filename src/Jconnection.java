import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jconnection {
public static void main(String[] args) {
	Connection con=null;
	try{
		//load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//connect to db
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","udhayak7777");
		//write a sql query
		String sql="select * from demo";
		//prepare the statement
		PreparedStatement ps=con.prepareCall(sql);
		//execute query
		ResultSet rs=ps.executeQuery();
		//Iterate the results
		while(rs.next()) {
			String first_name=rs.getString("first_name");
			String last_name=rs.getString("last_name");
			String address=rs.getString("address");
			String email=rs.getString("email");
			String phone=rs.getString("phone");
			String gender=rs.getString("gender");
			String hobbies=rs.getString("hobbies");
			String languages=rs.getString("languages");	
			System.out.println(first_name);
			System.out.println(last_name);
			System.out.println(address);		
			System.out.println(email);
			System.out.println(phone);
			System.out.println(gender);
			System.out.println(hobbies);
			System.out.println(languages);
			System.out.println();
		}
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}

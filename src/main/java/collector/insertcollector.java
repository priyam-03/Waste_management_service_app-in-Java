package collector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class insertcollector {
	private int password;
	private String name;
	private String email;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int addCollector() throws SQLException{
		//1. Register Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//2. Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		//3. SQL Query
		String sql = "insert into collector (password,name,email) values(?,?,?)";
		
		//4. Prepare & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		
		ps.setInt(1,password);
		
		ps.setString(2,name); 
		ps.setString(3,email);
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	                                                                                                         	
	 	int response = ps.executeUpdate();
		
		//close connection
		conn.close();
		
		return response;
	}
	public insertcollector search_data_byname() throws SQLException {
		// Register driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				
				
		//Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		Connection conn = DriverManager.getConnection(url, user, pass);

		// Sql query
		String sql = "SELECT * FROM collector where email = ? AND password= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,email);
		ps.setInt(2,password);
		
		java.sql.ResultSet rs = ps.executeQuery();
		insertcollector s = new insertcollector();
		int k=0;
		if (rs.next()) {
					
			k++;
			String name = rs.getString("name");
			
			s.setName(name);
		}
		
		if(k==0) {
			return null;
		}
		else {
			System.out.println("insertcollector: "+s);
			return s;
		}
			
}

	

}

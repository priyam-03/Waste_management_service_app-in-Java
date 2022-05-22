package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class insert {
	
	private int credit;
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	private String slot;
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getSubsname() {
		return subsname;
	}
	public void setSubsname(String subsname) {
		this.subsname = subsname;
	}
	private String subsname;

	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String name;
	private String email;
	private int id;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int addUser() throws SQLException{
		//1. Register Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//2. Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		//3. SQL Query
		String sql = "insert into user (password,name,email,address) values(?,?,?,?)";
		
		//4. Prepare & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		
		ps.setString(1,password);
		
		ps.setString(2,name); 
		ps.setString(3,email);
		ps.setString(4,address);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	                                                                                                         	
	 	int response = ps.executeUpdate();
	 	
	 	ResultSet resultSet = ps.getGeneratedKeys();
	 	int generated_id = 0;
	 	while(resultSet.next()) {
	 		
	 		 generated_id= (resultSet.getInt(1));
	 	}
		//close connection
		conn.close();
		
		return generated_id;
	}
	public int addSubscription() throws SQLException{
		//1. Register Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//2. Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		//3. SQL Query
		String sql = "insert into subscription (id,slot,subsname) values(?,?,?)";
		
		//4. Prepare & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		
		ps.setInt(1,id);
		
		ps.setString(2,slot); 
		ps.setString(3,subsname); 
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	                                                                                                         	
	 	int response = ps.executeUpdate();
		
		//close connection
		conn.close();
		
		return response;
	}
	

	public insert search_data_byname() throws SQLException {
		// Register driver
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				
				
		//Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		Connection conn = DriverManager.getConnection(url, user, pass);

		// Sql query
		String sql = "SELECT * FROM user where email = ? AND password= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,email);
		ps.setString(2,password);
		
		ResultSet rs = ps.executeQuery();
		insert s = new insert();
		int k=0;
		while(rs.next()) {
					
			k++;
			String name = rs.getString("name");
			int userid = rs.getInt("id");
			s.setName(name);
			s.setId(userid);
			System.out.println(k);
		}
		System.out.println(k);
		if(k==0) {
			return null;
		}
		else {
			System.out.println("insert: "+s);
			return s;
		}
		
			
}
	public ArrayList<insert> getuserdata() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		
		// Sql query
		String sql = "SELECT * FROM user ";
		
		//prepeardStatement & execute
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<insert> alluser = new ArrayList<>();
		while (rs.next()) {
		id = rs.getInt("id");
		name = rs.getString("name");
		email = rs.getString("email");
		address = rs.getString("address");
		insert s = new insert();
		s.setId(id);
		s.setAddress(address);
		s.setEmail(email);
		s.setName(name);
		alluser.add(s);
		

		}
		return alluser;
	}

	public int updateCredit() throws SQLException{
		//1. Register Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//2. Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		//3. SQL Query
		String sql = "update credit set credit=? where id=?";
		
		//4. Prepare & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		
		ps.setInt(1,credit);
		
		ps.setInt(2,id); 
		 
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	                                                                                                         	
	 	int response = ps.executeUpdate();
		
		//close connection
		conn.close();
		
		return response;
	}
	public int addCredit() throws SQLException{
		//1. Register Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//2. Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		//3. SQL Query
		String sql = "insert into credit (id,credit) values(?,?)";
		
		//4. Prepare & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		
		ps.setInt(1,id);
		
		ps.setInt(2,credit); 
		 
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	                                                                                                         	
	 	int response = ps.executeUpdate();
		
		//close connection
		conn.close();
		
		return response;
	}
	

	public ResultSet getcreditdata() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		
		// Sql query
		String sql = "SELECT * FROM credit where id=? ";
		
		//prepeardStatement & execute
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	public ArrayList<insert> getCompleteuserdata() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		
		// Sql query
		String sql = "SELECT * FROM user u , subscription s where u.id=s.id ";
		
		//prepeardStatement & execute
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<insert> userdetails = new ArrayList<>();
		while (rs.next()) {
		
		name = rs.getString("name");
		email = rs.getString("email");
		address = rs.getString("address");
		subsname = rs.getString("subsname");
		slot = rs.getString("slot");
		insert s = new insert();
		
		s.setAddress(address);
		s.setEmail(email);
		s.setName(name);
		s.setSlot(slot);
		s.setSubsname(subsname);
		userdetails.add(s);
		

		}
		return userdetails;
	}
	public ArrayList<insert> getoneuserdata() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//Connection
		String url = "jdbc:mysql://localhost:3306/waste";
		String user = "root";
		String pass = "";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		
		// Sql query
		String sql = "SELECT * FROM user u , subscription s where u.id=? AND u.id=s.id ";
		
		//prepeardStatement & execute
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		ArrayList<insert> oneuserdetails = new ArrayList<>();
		while (rs.next()) {
		
			name = rs.getString("name");
			email = rs.getString("email");
			address = rs.getString("address");
			subsname = rs.getString("subsname");
			slot = rs.getString("slot");
			insert s = new insert();
			
			s.setAddress(address);
			s.setEmail(email);
			s.setName(name);
			s.setSlot(slot);
			s.setSubsname(subsname);
			oneuserdetails.add(s);

		}
		return oneuserdetails;
	}



}

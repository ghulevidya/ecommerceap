package ecommersappvidya.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ecommersappvidya.entity.User;

public class UserJDBC {
	private Driver driver;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String query;
	private ResultSet resultSet;

	private void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_app", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (driver != null) {
			try {
				DriverManager.deregisterDriver(driver);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addUser(User user) {
		openConnection();
		query = "INSERT INTO user VALUES(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setLong(4, user.getMobile());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getRole());
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " row(s) affected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	public void findUserById(int id) {
		openConnection();
		query = "SELECT * FROM user WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getLong(4));
				System.out.println(resultSet.getString(5));
				System.out.println(resultSet.getString(6));
			} else
				System.out.println("User not found");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void findAllUsers() {
		openConnection();
		query = "SELECT * FROM user";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count++;
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("email"));
				System.out.println(resultSet.getLong("mobile"));
				System.out.println(resultSet.getString("password"));
				System.out.println(resultSet.getString("role"));
			}
			if (count == 0)
				System.out.println("Users not found");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void findUserByEmailAndPassword(String email, String password) {
		openConnection();
		query = "SELECT * FROM user WHERE email = ? AND password = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("User found");
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("email"));
				System.out.println(resultSet.getLong("mobile"));
				System.out.println(resultSet.getString("password"));
				System.out.println(resultSet.getString("role"));
			} else
				System.out.println("Invalid email or password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int id) {
		openConnection();
		query = "DELETE FROM user WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " row(s) affected");
			if (res != 0)
				System.out.println("User deleted");
			else
				System.out.println("Invalid user id");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void updateUser(int id,Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		 
    query="SELECT id FROM user WHERE id=?";
		
		openConnection();
		
		try {
			preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		
			
	if( resultSet.next() && resultSet.getInt("id")==id)
		{
		
			openConnection();
			query="UPDATE user SET id=?,name=?,email=?,mobile=?,password=?,role=? WHERE id=?" ;
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(7, id);
			
			
           	System.out.println("Enter new id");
		       int id1=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter new  name ");
			    String name=sc.nextLine();	
			System.out.println("Enter new  email ");
			      String email=sc.nextLine();
			System.out.println("Enter new  mobile ");
			Long mobile=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter new  password ");
			String password=sc.nextLine();
			System.out.println("Enter new  role");
			String role=sc.nextLine();
			User user=new User(id1, name, email, mobile, password, role);
			preparedStatement.setInt(1,id1);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, mobile);
			preparedStatement.setString(5, password);
			preparedStatement.setString(6, role);
			int res = preparedStatement.executeUpdate();
			if(res !=0)
			{
				System.out.println("User Updated");
			}}
			else
			{
				System.out.println("Invalid Id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	
		}}


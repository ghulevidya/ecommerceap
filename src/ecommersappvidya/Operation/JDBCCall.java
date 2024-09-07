package ecommersappvidya.Operation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCall {
	private static  Driver driver;
	 private static Connection connection;
	 private static String query;
	 private static  ResultSet resultSet;
	 private static CallableStatement callableStatement;
	 public static void main(String[] args) throws ClassNotFoundException {
		 try {
		openConnection();
		query="call sort(1)";
		callableStatement=connection.prepareCall(query);
		boolean res=callableStatement.execute();
		System.out.println(res);
		resultSet=callableStatement.getResultSet();
		while(resultSet.next())
		{
			System.out.println(resultSet.getString("name"));
		}
		 }catch(SQLException e){
			 e.printStackTrace();
			 
		 } finally {
			 closeConnection();
		 }
		}
		
	
private static void openConnection()
{
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_app", "root", "root");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private static void closeConnection()
{
	 if(callableStatement !=null)
	 {
		 try {
			 callableStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 if(connection !=null)
	 {
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

}

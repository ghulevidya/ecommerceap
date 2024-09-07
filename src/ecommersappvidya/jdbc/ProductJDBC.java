package ecommersappvidya.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ecommersappvidya.entity.Product;

public class ProductJDBC {

	private  Driver driver;
	 private  Connection connection;
	 private PreparedStatement preparedStatement;
	 private  String query;
	 private  ResultSet resultSet;
	 Scanner scanner=new Scanner(System.in);
	 private void openConnection()
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
	 private void closeConnection()
	 {
		 if(preparedStatement !=null)
		 {
			 try {
				preparedStatement.close();
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

	public void addProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter user id");
		int id=scanner.nextInt();
		query="SELECT role FROM user WHERE id=?";
		
		openConnection();
		
		try {
			preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		
			
	if( resultSet.next() && resultSet.getString("role").equals("SELLER"))
		{
		 System.out.print("Enter product id");
		int id2=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter product title");
		String title=scanner.nextLine();
		System.out.println("Enter product description");
		String description = scanner.nextLine();
		System.out.println("Enter product price");
		long price = scanner.nextLong();
		System.out.println("Enter product Status");
		boolean sold=scanner.nextBoolean(); 
		Product product = new Product(id2, title, description, price, sold);
//		List<Product> products = ProductCollection.getProducts();
//		products.add(product);
		openConnection();
		query="INSERT INTO product VALUES(?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getTitle());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setLong(4, product.getPrice());
		   preparedStatement.setBoolean(5,product.isSold());
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " row(s) affected");
		 }catch (SQLException e) {
				e.printStackTrace();
			} finally {
		closeConnection();
	}
		  }else
			{System.out.println("This not have Permission to add products");}
	
		}catch (SQLException e) {
	e.printStackTrace();
		} finally {
	closeConnection();
}}
	public void findProductById(int id) {
		// TODO Auto-generated method stub
		openConnection();
		query = "SELECT * FROM product WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getLong(4));
				System.out.println(resultSet.getBoolean(5));
				
			} else
				System.out.println("Product not found");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	public void findAllProducts() {
		// TODO Auto-generated method stub
		openConnection();
		query = "SELECT * FROM product";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count++;
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("title"));
				System.out.println(resultSet.getString("description"));
				System.out.println(resultSet.getLong("price"));
				System.out.println(resultSet.getBoolean("sold"));
				
			}
			if (count == 0)
				System.out.println("Products not found");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		openConnection();
		query = "SELECT role FROM user WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
		//	System.out.println(resultSet);
			
			if (resultSet.next() && resultSet.getString("role").equalsIgnoreCase("SELLER"))
			{
				System.out.println("Enter product id");
				int id1 = scanner.nextInt();
				openConnection();
			query = "DELETE FROM product WHERE id = ?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id1);
				int res = preparedStatement.executeUpdate();
			//	System.out.println(res + " row(s) affected");
				if (res != 0)
					System.out.println("Productr deleted");
				else
					System.out.println("Invalid Product id");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}}
	      else
				{System.out.println("Invalid user id");
				}

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}
	public void updateProduct() {
		// TODO Auto-generated method stub
		System.out.println("Enter user id");
		int id1=scanner.nextInt();
		openConnection();
		query = "SELECT role FROM user WHERE id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id1);
			resultSet = preparedStatement.executeQuery();
		//	System.out.println(resultSet);
			
			if (resultSet.next() && resultSet.getString("role").equalsIgnoreCase("SELLER")) {
				openConnection();
				System.out.println("Enter Product id");
				int id=scanner.nextInt();
			    query="UPDATE product SET id=?,title=?,description=?,price=?,sold=? where id=?";	
			    preparedStatement=connection.prepareStatement(query);
			    preparedStatement.setInt(6, id);
			 	System.out.println("Enter new product id");
			       int id3=scanner.nextInt();
			       System.out.println("Enter new product Title");
			       String title=scanner.nextLine();
			       scanner.nextLine();
			       System.out.println("Enter new  product Description");
			       String description=scanner.nextLine();
			       System.out.println("Enter new  product Price");
			       long price=scanner.nextLong();
			       System.out.println("Enter new  product sold status");
			       boolean sold=scanner.nextBoolean();
			       Product product=new Product(id3, title, description, price, sold);
			       preparedStatement.setInt(1, id);
			       preparedStatement.setString(2, title);
			       preparedStatement.setString(3, description);
			       preparedStatement.setLong(4, price);
			       preparedStatement.setBoolean(5, sold);
			       int res = preparedStatement.executeUpdate();
					if(res !=0)
					{
						System.out.println("Product Updated");
					}
		}
		            else
		              {
						System.out.println("Invalid  product Id");
					}
					
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
	}

}

package ecommersappvidya.main;

import java.sql.SQLException;
import java.util.Scanner;

import ecommersappvidya.Operation.UserOperation;
import ecommersappvidya.entity.User;

public class UserMain {
	private static UserOperation userOperation = new UserOperation();
     private static User user=new User();
    private static ProductMain main=new ProductMain(); 
	public static void main(String[] args) throws SQLException {

//		UserOperation userOperation=new UserOperation();

		Scanner scanner = new Scanner(System.in);

		boolean flag = true;

		while (flag) {
			System.out.println(
					"Enter 1 for sign up \nEnter 2 for log in \nEnter 3 to find all users\nEnter 4 Fine user by id\nEnter 5 to delete  user\nEnter 6 to Update User details\nEnter 7 for Products");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:

				UserOperation.addUser(scanner);
				break;
			case 2:
//		User user = userOperation.findUserByEmailAndPassword(scanner);
//				if (user != null) {
//					System.out.println("User found");
//					ProductMain.main(user, scanner);
//				} else {
//					
//					System.out.println("Invalid email or password");
//				}
				userOperation.findUserByEmailAndPassword(scanner);
				break;

			case 3:
				userOperation.findAllUsers();
				break;
			case 4:
				userOperation.findUserById(scanner);
				break;
			case 5:
				userOperation.deleteUser(scanner);
				break;
			case 6:
				userOperation.updateUser(scanner);
				break;

			case 7:
				System.out.println("Product Information");
				main.main(user, scanner);
				
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}

		}
		scanner.close();
	}
}

package ecommersappvidya.main;
import java.util.Scanner;

import ecommersappvidya.entity.User;
import ecommersappvidya.Operation.ProductOperation;

public class ProductMain {
	private static ProductOperation productOperation=new ProductOperation();
//	public static void main(String[] args)
//	{ 
//		User user=new User();
//		Scanner scanner=new Scanner("System.in");
////	   main(user, scanner);	
////	}
	
	public static void main(User user,Scanner scanner)
	{
		
		boolean flag = true;
		while (flag) {
			System.out
					.println("=========================================================================================================================================================");
			System.out.println(
					"Enter 1 to add product \nEnter 2 to find product by id \nEnter 3 to find all products \nEnter 4 to delete product \nEnter 5 to update product \nEnter 6 to go back");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
//			      System.out.println("Enter user id");
//			      int id=scanner.nextInt();
			    //  System.out.println("user Role:"+user.getRole());
		          // if(id !=0)
		         //  {
		          // System.out.println("user Role:"+user.getRole());
		   
				//if (user.getRole() !=null && user.getRole().equals("SELLER")){
					productOperation.addProduct(scanner);
				
				//}else {
					//System.out.println("Unauthorized access");
				//}
				break;
			case 2:
				productOperation.findProductById(scanner);
				break;
			case 3:
				productOperation.findAllProducts();
				break;
			case 4:
//				System.out.println("Enter user id");
//				int id=scanner.nextInt();
			//	if(id ==user.getId()) {
			//	if (user.getRole() !=null && user.getRole().equals("SELLER")) {
			//		System.out.println(user.getRole());
					productOperation.deleteProduct(scanner);
			//	} }else {
				//	System.out.println("Unauthorized access");
				//}
				break;
			case 5:{
				
					productOperation.updateProduct(scanner);
				 
				}
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
			
			
      
		
	}

}}

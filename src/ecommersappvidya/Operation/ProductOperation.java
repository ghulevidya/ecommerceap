package ecommersappvidya.Operation;

import java.util.Scanner;

import java.util.List;
import java.util.Scanner;
import ecommersappvidya.collection.ProductCollection;
import ecommersappvidya.entity.Product;
import ecommersappvidya.jdbc.ProductJDBC;


public class ProductOperation {

	private static ProductCollection productCollection = new ProductCollection();

   private static ProductJDBC jdbc=new ProductJDBC();
	public void addProduct(Scanner scanner) {
		// TODO Auto-generated method stub
//		System.out.print("Enter product id");
//		int id=scanner.nextInt();
//		scanner.nextLine();
//		System.out.println("Enter product title");
//		String title=scanner.nextLine();
//		System.out.println("Enter product description");
//		String description = scanner.nextLine();
//		System.out.println("Enter product price");
//		long price = scanner.nextLong();
//		System.out.println("Enter product Status");
//		boolean sold=scanner.nextBoolean(); 
//		Product product = new Product(id, title, description, price, sold);
////		List<Product> products = ProductCollection.getProducts();
////		products.add(product);
		jdbc.addProduct();
		System.out.println("Product added");
	
	}
		
	public void findProductById(Scanner scanner) {

		System.out.println("Enter product id");
		int id = scanner.nextInt();
//		List<Product> products = productCollection.getProducts();
//		Product productById = null;
//		for (Product product : products) {
//			if (product.getId() == id) {
//				productById = product;
//				break;
//			}
//		}
//		if (productById != null) {
//			System.out.println(productById);
//		} else {
//			System.out.println("Product not found");
//		}
           jdbc.findProductById(id);
	}
	public void findAllProducts() {

//		List<Product> products = productCollection.getProducts();
//		if (products.size() > 0) {
//			for (Product product : products) {
//				System.out.println(product);
//			}
//		} else {
//			System.out.println("Products not found");
//		}
           jdbc.findAllProducts();
	}
	public void deleteProduct(Scanner scanner) {

		System.out.println("Enter user id");
		int id = scanner.nextInt();
//		List<Product> products = productCollection.getProducts();
//		Product productToBeDeleted = null;
//		for (Product product : products) {
//			if (product.getId() == id) {
//				productToBeDeleted = product;
//				break;
//			}
//		}
//		if (productToBeDeleted != null) {
//			products.remove(productToBeDeleted);
//			System.out.println("Product deleted");
//		} else {
//			System.out.println("Invalid product id");
//		}
          jdbc.deleteProduct(id);
	}
	public void updateProduct(Scanner scanner) {

//		System.out.println("Enter product id");
//		int id = scanner.nextInt();
//		List<Product> products = productCollection.getProducts();
//		Product productToBeUpdated = null;
//		for (Product product : products) {
//			if (product.getId() == id) {
//				productToBeUpdated = product;
//				break;
//			}
//		}
//		if (productToBeUpdated != null) {
//
//			scanner.nextLine();
//			System.out.println("Enter product title");
//			String newTitle = scanner.nextLine();
//			System.out.println("Enter product description");
//			String newDescription = scanner.nextLine();
//			System.out.println("Enter product price");
//Long newPrice = scanner.nextLong();
//			productToBeUpdated.setTitle(newTitle);
//			productToBeUpdated.setDescription(newDescription);
//			productToBeUpdated.setPrice(newPrice);
//			System.out.println("Select product sale status");
//			System.out.println("Enter 1 for sold \nEnter 2 for unsold");
//			int choice = scanner.nextInt();
//			switch (choice) {
//			case 1:
//				productToBeUpdated.setSold(true);
//				break;
//			case 2:
//				productToBeUpdated.setSold(false);
//				break;
//			default:
//				System.out.println("Invalid choice");
//			}
//			System.out.println("Product updated");
//
//		} else {
//			System.out.println("Invalid product id");
//		}
            jdbc.updateProduct();
	}
		
	
	
	

	
	}



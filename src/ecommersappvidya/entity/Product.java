package ecommersappvidya.entity;



public class Product {
	private int id;
	private String title;
	private String description;
	private Long price;
	private boolean sold;
	
	public Product(int id, String title, String description, Long price2,boolean sold2) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price2;
		this.sold = sold2;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean b) {
		this.sold = b;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", sold=" + sold + "]";
	}
	
	
	

}

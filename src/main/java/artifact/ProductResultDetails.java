package artifact;



public class ProductResultDetails {
	String productName;
	String productPrice;
	String productLink;
	
	
	public ProductResultDetails(String productName, String productPrice, String productLink) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productLink = productLink;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductLink() {
		return productLink;
	}
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
	
	

}

package dto;

public class ProductVO {
	private int id;          //대분류ID
	private int prodCategory;   // 소분류ID 
	private String prodName;    //상품이름 
	private String prodDetail;  //상품 상세정보 
	private int price;          //상품가격 
	private int discount;       //할인 
	private String packageType; //보관방법 
	private String origin;      //원산지
	private String prodImg;     //제품 이미지 경로
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(int prodCategory) {
		this.prodCategory = prodCategory;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", prodCategory=" + prodCategory + ", prodName=" + prodName + ", prodDetail="
				+ prodDetail + ", price=" + price + ", discount=" + discount + ", packageType=" + packageType
				+ ", origin=" + origin + ", prodImg=" + prodImg + "]";
	}
}

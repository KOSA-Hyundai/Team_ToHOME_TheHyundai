package dto;

public class ProductVO {
	private int id;          //��з�ID
	private int prodCategory;   // �Һз�ID 
	private String prodName;    //��ǰ�̸� 
	private String prodDetail;  //��ǰ ������ 
	private int price;          //��ǰ���� 
	private int discount;       //���� 
	private String packageType; //������� 
	private String origin;      //������
	private String prodImg;     //��ǰ �̹��� ���
	
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

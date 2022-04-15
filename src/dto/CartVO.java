package dto;

// 작성자 : 고정민
// 장바구니 목록 조회 시 필요한 상품 정보와 수량을 담은 VO
public class CartVO {
	private int id; // 장바구니 아이디 
	private int prod_id; // 상품 아이디 
	private String email; // 사용자 이메일 
	private int qty; // 상품 수량
	private String useyn; // 장바구니 활성화 여부 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}// end class

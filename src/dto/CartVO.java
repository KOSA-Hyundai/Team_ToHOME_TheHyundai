package dto;

public class CartVO {
	private int id;
	private int prod_id;
	private String email;
	private int qty;
	private String useyn;

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

package dto;

public class SmallCategoryDTO {
	private int id;
	private String smallCategory;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSmallCategory() {
		return smallCategory;
	}
	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}
	public SmallCategoryDTO(int id, String smallCategory) {
		super();
		this.id = id;
		this.smallCategory = smallCategory;
	}
	@Override
	public String toString() {
		return "SmallCategoryDTO [id=" + id + ", smallCategory=" + smallCategory + "]";
	}	
	
}

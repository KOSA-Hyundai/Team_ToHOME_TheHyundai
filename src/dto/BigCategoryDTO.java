package dto;

import java.util.ArrayList;

public class BigCategoryDTO {
	private int id;
	private String bigCategory;
	private ArrayList<SmallCategoryDTO> smallCategoryList = new ArrayList<>();
		
	public String getBigCategory() {
		return bigCategory;
	}
	public void setBigCategory(String bigCategory) {
		this.bigCategory = bigCategory;
	}
	public ArrayList<SmallCategoryDTO> getSmallCategoryList() {
		return smallCategoryList;
	}
	public void setSmallCategory(ArrayList<SmallCategoryDTO> smallCategoryList) {
		this.smallCategoryList = smallCategoryList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public BigCategoryDTO(int id, String bigCategory) {
		super();
		this.id = id;
		this.bigCategory = bigCategory;
	}
	public void addSmallCategory(SmallCategoryDTO smallCategoryDTO) {
		this.smallCategoryList.add(smallCategoryDTO);
	}
	@Override
	public String toString() {
		return "BigCategoryDTO [id=" + id + ", bigCategory=" + bigCategory + ", smallCategoryList=" + smallCategoryList
				+ "]";
	}	
	
}

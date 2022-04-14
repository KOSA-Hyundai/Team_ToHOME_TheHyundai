package dto;

import java.util.ArrayList;

public class BigCategoryVO {
	private int id;
	private String bigCategory;
	private ArrayList<SmallCategoryVO> smallCategoryList = new ArrayList<>();
		
	public String getBigCategory() {
		return bigCategory;
	}
	public void setBigCategory(String bigCategory) {
		this.bigCategory = bigCategory;
	}
	public ArrayList<SmallCategoryVO> getSmallCategoryList() {
		return smallCategoryList;
	}
	public void setSmallCategory(ArrayList<SmallCategoryVO> smallCategoryList) {
		this.smallCategoryList = smallCategoryList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public BigCategoryVO(int id, String bigCategory) {
		super();
		this.id = id;
		this.bigCategory = bigCategory;
	}
	public void addSmallCategory(SmallCategoryVO smallCategoryDTO) {
		this.smallCategoryList.add(smallCategoryDTO);
	}
	@Override
	public String toString() {
		return "BigCategoryDTO [id=" + id + ", bigCategory=" + bigCategory + ", smallCategoryList=" + smallCategoryList
				+ "]";
	}	
	
}

package dto;

import java.util.Arrays;

// 작성자 : 정예성 
public class CategoryVO {
	private int bigId;              // 대분류 카테고리 ID
	private int smallId;            // 소분류 카테고리 ID 
	private String bigCategory;     // 대분류 카테고리명 
	private String[] smallCategory; // 소분류 카테고리명 
	
	public int getBigId() {
		return bigId;
	}
	public void setBigId(int bigId) {
		this.bigId = bigId;
	}
	public int getSmallId() {
		return smallId;
	}
	public void setSmallId(int smallId) {
		this.smallId = smallId;
	}
	public String getBigCategory() {
		return bigCategory;
	}
	public void setBigCategory(String bigCategory) {
		this.bigCategory = bigCategory;
	}
	
	public String[] getSmallCategory() {
		return smallCategory;
	}
	public void setSmallCategory(String[] smallCategory) {
		this.smallCategory = smallCategory;
	}
	
	@Override
	public String toString() {
		return "CategoryVO [bigId=" + bigId + ", smallId=" + smallId + ", bigCategory=" + bigCategory
				+ ", smallCategory=" + Arrays.toString(smallCategory) + "]";
	}
}

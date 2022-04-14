package dto;

import java.util.Arrays;

// �ۼ��� : ������ 
public class CategoryVO {
	private int bigId;              // ��з� ī�װ� ID
	private int smallId;            // �Һз� ī�װ� ID 
	private String bigCategory;     // ��з� ī�װ��� 
	private String[] smallCategory; // �Һз� ī�װ��� 
	
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

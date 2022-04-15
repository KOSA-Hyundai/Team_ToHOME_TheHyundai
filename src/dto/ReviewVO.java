package dto;
import java.sql.Timestamp;
import java.time.LocalDateTime;

// �ۼ��� : �迬�� 
public class ReviewVO {
	
	private int id;                 // ���� ���� ID 
	private int user_id;            // ���� ID 
	private int prod_id;            // ��ǰ ID 
	private String contents;        // ���� ���� 
	private String score;           // ��ǰ ���� 
	private Timestamp create_date;  // �ۼ� ���� 
	private String name;            // �ۼ��� �̸�
	
	public ReviewVO() {
		super();
	}
	public ReviewVO(int id, int user_id, int prod_id, String contents, String score, Timestamp create_date, String name) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.prod_id = prod_id;
		this.contents = contents;
		this.score = score;
		this.create_date = create_date;
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	
	
}


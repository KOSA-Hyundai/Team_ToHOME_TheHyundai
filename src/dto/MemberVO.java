package dto;

// 작성자 : 고정민
// 회원 정보를 담은 VO
public class MemberVO {
    private String email; // 이메일 
    private String name; // 이름 
    private String pw; // 비밀번호 
    private String phone_number; // 전화번호
    private String birth; // 생년월일
    private String gender; // 성별 
    private String address; // 주소

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) { this.pw = pw; }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
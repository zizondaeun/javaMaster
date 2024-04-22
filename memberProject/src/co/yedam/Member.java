package co.yedam;

public class Member {
	private int memNo;
	private String name;
	private String phone;
	private String births;
	private String gender;
	
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirths() {
		return births;
	}
	public void setBirths(String births) {
		this.births = births;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
//		회원번호 회원명 회원연락처 		회원생일(string) 성별
//		return "member [memNO=" + memNo + ", name=" + name + ", phone=" + phone + ", births=" + births + ", gerder="
//				+ gerder + "]";
		return String.format("%d %3s %13s %8s %2s", memNo,name,phone,births,gender);
	}
	
	
	
	
}

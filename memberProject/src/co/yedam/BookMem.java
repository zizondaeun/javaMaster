package co.yedam;

public class BookMem {
	private int memNo;
	private String memName;
	private String memPhone;
	private String memBirth;
	private String memAddress;
	private String returnStatus;
	//private String bookNo;
	
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	@Override
	public String toString() {
		return "BookMem [memNo=" + memNo + ", memName=" + memName + ", memPhone=" + memPhone + ", memBirth=" + memBirth
				+ ", memAddress=" + memAddress + ", returnStatus=" + returnStatus + "]";
	}
	
	
	

}

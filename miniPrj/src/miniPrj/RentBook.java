package miniPrj;

public class RentBook {
	private int rentNo;
	private int bookNo;
	private int memNo;
	private String returnStatus;
	private String returnDate;
	private String bookTitle;
	
	
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	@Override
	public String toString() {
//		return 
		return "RentBook [rentNo=" + rentNo + ", bookNo=" + bookNo + ", memNo=" + memNo + ", returnStatus="
		+ returnStatus + ", returnDate=" + returnDate + ", bookTitle=" + bookTitle + "]";
	}
	

	
	
	
}

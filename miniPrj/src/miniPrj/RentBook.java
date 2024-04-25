package miniPrj;

public class RentBook {
	private int rentNo;
	private int bookNo;
	private int memNo;
	private String memName;
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

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
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
		// 대출번호 도서번호(도서명) 회원번호(회원명) 반납현황 반납일자
		while (bookTitle.length() < 10) {
			bookTitle += " ";
		}
		String bt = bookTitle.substring(0, 10);
		return String.format("%-3d %5d(%-10s) %-2d(%-3s) %10s %21s", rentNo, bookNo, bt, memNo, memName, returnStatus,
				returnDate);

//		return "RentBook [rentNo=" + rentNo + ", bookNo=" + bookNo + ", memNo=" + memNo + ", returnStatus="
//		+ returnStatus + ", returnDate=" + returnDate + ", bookTitle=" + bookTitle + "]";
	}

}

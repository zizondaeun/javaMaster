package miniPrj;

public class Search {
	private String bookNo;//대출
	private String memNo;
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	@Override
	public String toString() {
		return "Search [bookNo=" + bookNo + ", memNo=" + memNo + "]";
	}
	
	
}

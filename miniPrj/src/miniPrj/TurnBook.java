package miniPrj;

public class TurnBook {
	private int bookNo;
	private int memNo;
	
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
	@Override
	public String toString() {
		return "TurnBook [bookNo=" + bookNo + ", memNo=" + memNo + "]";
	}
	
	
}

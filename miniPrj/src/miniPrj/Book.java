package miniPrj;

public class Book {
	private int bookNo;
	private String bookTitle;
	private String bookWriter;
	private String publish;
	private String pubDate;
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
//	@Override
//	public String toString() {
//		return bookNo + "\t" + bookTitle + "\t  " + bookWriter + "\t" + publish + "\t" + pubDate;
//	}
	
	@Override
	public String toString() {
		return String.format("%-7d %-9s %-5s %-9s %10s", bookNo, bookTitle, bookWriter, publish, pubDate);
	}	
	
	
	
	
	
	
	
}

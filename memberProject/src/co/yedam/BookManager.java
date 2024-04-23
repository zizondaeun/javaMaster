package co.yedam;

import java.util.List;
import java.util.Scanner;

public class BookManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		BookDAO dao = new BookDAO();
		
		while(run) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("1.도서정보 조회 2.도서등록 3.도서정보수정 4.도서삭제 5.회원조회 6.대출/반납현황 7.종료");
			System.out.print("선택> ");
			int selectNo = sc.nextInt();
			//int selectNo = Integer.parseInt(sc.nextLine());
			System.out.println("---------------------------------------------------------------------");
			
			switch(selectNo) {
			case 1 : 
				List<Book> books = dao.bookList();
				//System.out.println("--------------------------------");
				System.out.println("도서번호\t도서제목\t    저자\t   출판사\t   출판일\n");
				System.out.println("---------------------------------------------------------------------");
				for(Book book : books) {
					System.out.println(book.toString());
				}
				break;
			case 2 :
				System.out.print("도서제목 >> ");
				String bookTitle = sc.next();
				System.out.print("저자   	>> ");
				String bookWriter = sc.nextLine();
				System.out.print("출판사	>> ");
				String publish = sc.nextLine();
				System.out.print("출판일	>> ");
				String pubDate = sc.nextLine();
				
				Book book = new Book();
				book.setBookTitle(bookTitle);
				book.setBookWriter(bookWriter);
				book.setPublish(publish);
				book.setPubDate(pubDate);
				
				if(dao.insertBook(book)) {
					System.out.println("도서등록 완료");
				}else {
					System.out.println("등록오류");
				}
				break;
			case 3 :
				System.out.print("수정할 도서번호 >> ");
				int bookNo = sc.nextInt();
				System.out.print("도서제목 >> ");
				bookTitle = sc.nextLine();
				System.out.print("저자   	>> ");
				bookWriter = sc.nextLine();
				System.out.print("출판사	>> ");
				publish = sc.nextLine();
				System.out.print("출판일	>> ");
				pubDate = sc.nextLine();
				
				book = new Book();
				book.setBookTitle(bookTitle);
				book.setBookWriter(bookWriter);
				book.setPublish(publish);
				book.setPubDate(pubDate);
				
				if(dao.updateBook(book)) {
					System.out.println("도서수정 완료");
				}else {
					System.out.println("수정오류");
				}
				break;
			case 4 :
				System.out.print("삭제할 도서번호");
				bookNo = sc.nextInt();
				sc.nextLine();
				
				if(dao.deleteBook(bookNo)) {
					System.out.println("도서삭제 완료");
				}else {
					System.out.println("삭제오류");
				}
				break;
			case 5 : 
				
			case 6 :
				
			case 7 :
				System.out.println("프로그램종료");
				run = false;
			}
		}
		System.out.println();

	}

}

package miniPrj;

import java.util.List;
import java.util.Scanner;

public class BookManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		BookDAO dao = new BookDAO();
		BookMemDAO bmdao = new BookMemDAO();
		RentDAO rtdao = new RentDAO();
		Search search = new Search();
//		2.도서등록 3.도서정보수정 4.도서삭제 
		while (run) {
			System.out.println("===========================[도서관 사서 프로그램]==========================");
			System.out.println("1.도서정보 조회 2.도서관리 3.회원조회 4.대출/반납현황 5.종료");
			System.out.println("=====================================================================");
			System.out.print("선택> ");
			
			int selectNo = sc.nextInt();
			sc.nextLine();
			// int selectNo = Integer.parseInt(sc.nextLine());

			switch (selectNo) {
			case 1:
				List<Book> books = dao.bookList();
//				System.out.println("---------------------------------------------------------------------");
				System.out.println("도서번호\t도서제목\t    저자\t   출판사\t   출판일\n---------------------------------------------------------------------");
//				System.out.println("---------------------------------------------------------------------");
//				System.out.printf("도서번호	도서제목		저자		출판사	출판일\n");
				
				for (Book book : books) {
					System.out.println(book.toString());
				}
				break;
			case 2:	
				System.out.print("찾고있는 도서제목   >> ");
				String bookName = sc.nextLine();
				

			case 3:
				boolean run2 = true;
				while(run2) {
					System.out.println("1.도서등록 2.도서정보수정 3.도서삭제 4.이전메뉴");
					System.out.println("선택>");
					int menu = Integer.parseInt(sc.nextLine());
					
					switch(menu) {
					case 1 ://도서등록
						System.out.print("도서제목   >> ");
						String bookTitle = sc.nextLine();
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
						
						if (dao.insertBook(book)) {
							System.out.println("도서등록 완료");
						} else {
							System.out.println("등록오류");
						}
						break;
						
					case 2 ://도서수정
						System.out.print("수정할 도서번호 >> ");
						int bookNo = sc.nextInt();
						sc.nextLine();
						
						System.out.print("도서제목   >> ");
						bookTitle = sc.nextLine();
						System.out.print("저자   	>> ");
						bookWriter = sc.nextLine();
						System.out.print("출판사	>> ");
						publish = sc.nextLine();
						System.out.print("출판일	>> ");
						pubDate = sc.nextLine();
						
						book = new Book();
						book.setBookNo(bookNo);
						book.setBookTitle(bookTitle);
						book.setBookWriter(bookWriter);
						book.setPublish(publish);
						book.setPubDate(pubDate);
						
						if (dao.updateBook(book)) {
							System.out.println("도서수정 완료");
						} else {
							System.out.println("수정오류");
						}
						break;
						
					case 3 ://도서삭제
						System.out.print("삭제할 도서번호   	>>");
						bookNo = sc.nextInt();
						sc.nextLine();
						
						if (dao.deleteBook(bookNo)) {
							System.out.println("도서삭제 완료");
						} else {
							System.out.println("삭제오류");
						}
						break;
					case 4 :
						run2 = false;
						break;
					}
				}break;
				
			case 4:
				List<BookMem> mems = bmdao.bookmemList(null);
				System.out.println("회원번호 회원이름 회원연락처 \t  생년월일\t\t    	주소");
				System.out.println("---------------------------------------------------------------------");
				for (BookMem bookmem : mems) {
					System.out.println(bookmem.toString());
				}
				break;
			case 5:
				List<RentBook> rtbooks = rtdao.rentList(new Search());
				System.out.println("대출현황");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("대출번호	도서번호(도서제목)	회원번호(회원이름)	반납현황	반납일자");
				System.out.println("---------------------------------------------------------------------");
				for (RentBook rtbook : rtbooks) {
					System.out.println(rtbook.toString());
				}
				RentProc proc = new RentProc();
				proc.exe();

				break; //

			case 6:
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		System.out.println();

	}

}

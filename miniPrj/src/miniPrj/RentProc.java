package miniPrj;

import java.util.List;
import java.util.Scanner;

public class RentProc {

	Scanner scn = new Scanner(System.in);
	RentDAO dao = new RentDAO();
	BookMemDAO bdao = new BookMemDAO();
	
	void rentBook() { //대출하기
		int mno = -1;
		while (true) {
			System.out.print("회원이름   >> ");
			String name = scn.nextLine();
			try {
				mno = Integer.parseInt(name);
				break;
			} catch (NumberFormatException e) {
				List<BookMem> list = bdao.bookmemList(name);
				if (list.size() == 0) {
					System.out.println("조회된 결과가 없습니다. ");
					continue;
				}
				list.forEach(member -> System.out.println(member)); //화살표함수
				System.out.print("회원번호   >> "); //회원번호를 알고있다면
				mno = Integer.parseInt(scn.nextLine());
				break;
			}
		}
		
		System.out.print("도서번호   >> ");
		int bno = Integer.parseInt(scn.nextLine());

		RentBook rbook = new RentBook();
		rbook.setBookNo(bno);
		rbook.setMemNo(mno);

		if (dao.rentBook(rbook)) {
			System.out.println("*대출완료*");
		} else {
			System.out.println("*대출실패*");
		}
	}

	void returnBook() { //반납하기
		System.out.print("반납할 도서번호 >> ");
		int bno = Integer.parseInt(scn.nextLine());
		System.out.print("반납할 회원번호 >> ");
		int mno = Integer.parseInt(scn.nextLine());

		TurnBook tbook = new TurnBook();
		tbook.setBookNo(bno);
		tbook.setMemNo(mno);

		if (dao.rentBook(tbook)) {
			System.out.println("*반납완료*");
		} else {
			System.out.println("*반납실패*");
		}
	}

	public void exe() { //대출반납관리
		boolean run = true;
		while (run) {
			System.out.println("| 1.대출하기 | 2.반납하기 | 3.이전메뉴 |");
			System.out.print("선택> ");
			try { // 문자 입력 시 예외처리
				int menu = Integer.parseInt(scn.nextLine());
				
				switch (menu) {
				case 1: // 대출.
					rentBook();
					break;
				case 2: // 반납.
					returnBook();
					break;
				case 3: // 이전화면
					System.out.println();
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("*숫자로 입력하세요.*");
			}
			
			
		}
	}
}

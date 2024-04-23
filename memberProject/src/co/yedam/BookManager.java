package co.yedam;

import java.util.Scanner;

public class BookManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		BookDAO dao = new BookDAO();
		
		while(run) {
			System.out.println("1.도서정보 조회 2.도서등록 3.도서정보수정 4.도서삭제 5.회원조회 6.도서대출/반납현황 7.종료");
			System.out.print("선택> ");
			int selectNo = sc.nextInt();
			//
			
			switch(selectNo) {
			case 1 : 
			
			case 2 :
				
			case 3 :
				
			case 4 :
			
			case 5 : 
			
			case 6 :
				
			case 7 :
				
			}
		}

	}

}

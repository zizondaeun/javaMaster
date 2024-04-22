package co.yedam;

import java.util.List;
import java.util.Scanner;

public class MemManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		MemberDAO dao = new MemberDAO();
		
		while(run) {
			System.out.println("1.회원목록 2.회원등록 3.정보수정 4.회원삭제 5.종료");
			System.out.print("선택> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				List<Member> mems = dao.memList();
				System.out.println("회원번호	회원명	회원연락처	회원생일	성별");
				System.out.println("-----------------------------------------");
				for(Member mem : mems) {
					System.out.println(mem.toString());
				}
				break;
			case 2 :
				System.out.print("회원명>> ");
				String name = sc.nextLine();
				System.out.print("회원연락처>> ");
				String phone = sc.nextLine();
				System.out.print("회원생일>> ");
				String births = sc.nextLine();
				System.out.print("성별>>");
				String gender = sc.nextLine();
				
				Member mem = new Member();
				//mem.setMemNo(menu);
				mem.setName(name);
				mem.setPhone(phone);
				mem.setBirths(births);
				mem.setGender(gender);
				
				if(dao.insertMem(mem)) {
					System.out.println("저장완료");
				}else {
					System.out.println("예외발생");
				}
				break;
			case 3 :
				System.out.print("수정할 회원번호>>");
				int memNo = sc.nextInt();
				System.out.print("연락처>>");
				phone = sc.nextLine();
				
				mem = new Member();
				mem.setPhone(phone);
				
				if(dao.updateMem(mem)) {
					System.out.println("수정완료");
				}else {
					System.out.println("예외발생");
				}
				break;
				
			case 4 :
				System.out.print("삭제할 회원번호");
				memNo = sc.nextInt();
				sc.nextLine();
				
				if(dao.deleteMem(memNo)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("예외발생");
				}
				break;
			case 5 :
				System.out.println("종료");
				run = false;
			}
		}
		System.out.println("end of prog.");

	}

}

package miniPrj;

public class AppTest {
	public static void main(String[] args) {
		RentDAO dao= new RentDAO();
		Search search = new Search();
//		search.setBookNo("1");
		search.setMemNo("4");
		dao.rentList(search).forEach(System.out::println);
	}
}

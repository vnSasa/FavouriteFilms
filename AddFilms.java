import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;


public class AddFilms {

	public AddFilms() {
		System.out.println("���� ��������� ��������� ������");
		
		Scanner scan = new Scanner(System.in);
		boolean ch;
		
		while (ch = true) {
			System.out.println("������ ������ �����? (1) - ��� (2) - Ͳ");
			int choice = scan.nextInt();
			if (choice == 1) {
				ch = true;
				AddFilmsDB film = new AddFilmsDB();
			} else { 
				ch = false;
				ChoiceMenu back = new ChoiceMenu();
				break;
			}
			
		}
	}
	
}

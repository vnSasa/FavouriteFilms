import java.util.Scanner;

public class Autorization {
	
	public Autorization() {
		System.out.println("���� �����, �������������");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("���� � ��� � �������� ����� ������ (1):\n���� �� ���� �������� �������� ����� ������ (2):");
		int option = scan.nextInt();
		
		if (option == 1) {
			LogIn log = new LogIn();
		}
		
		else if (option == 2) {
			Registration reg = new Registration();
		}
	}

}

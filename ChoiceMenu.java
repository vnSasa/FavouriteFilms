import java.util.Scanner;

public class ChoiceMenu {
	
	Scanner scan = new Scanner(System.in);
	
	public ChoiceMenu() {
		System.out.println("�� ���� ������� 䳿? \n (1) - ����������� ������ ��������� ������ ������������; \n (2) - ������ �� ������ ��� ������� ������.\n ������, ���� �����, ����: ");
		int choice = scan.nextInt();
		if (choice == 1) {
			ViewFilms view = new ViewFilms();
		} else if (choice == 2) {
			AddFilms addF = new AddFilms();
		}
	}
	
}

import java.util.Scanner;

public class ChoiceMenu {
	
	Scanner scan = new Scanner(System.in);
	
	public ChoiceMenu() {
		System.out.println("Які ваші наступні дії? \n (1) - переглянути список улюблених фільмів користувачів; \n (2) - додати до списку свої улюблені фільми.\n Зробіть, будь ласка, вибір: ");
		int choice = scan.nextInt();
		if (choice == 1) {
			ViewFilms view = new ViewFilms();
		} else if (choice == 2) {
			AddFilms addF = new AddFilms();
		}
	}
	
}

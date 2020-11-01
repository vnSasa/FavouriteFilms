import java.util.Scanner;

public class Autorization {
	
	public Autorization() {
		System.out.println("Ѕудь ласка, авторизуйтес€");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("якщо у вас Ї обл≥ковий запис введ≥ть (1):\nякщо ви баЇте створити обл≥ковий запис введ≥ть (2):");
		int option = scan.nextInt();
		
		if (option == 1) {
			LogIn log = new LogIn();
		}
		
		else if (option == 2) {
			Registration reg = new Registration();
		}
	}

}

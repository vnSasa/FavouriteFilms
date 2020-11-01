import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Registration {

	public Registration() {
		
		try{
	        String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
	        String username = "root";
	        String password = "11052013s";
	        Scanner scan = new Scanner(System.in);
	        
	        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	        
	        	System.out.print("¬вед≥ть лог≥н: ");
	        	String login = scan.nextLine();
	        	
	        	System.out.print("¬вед≥ть пароль: ");
	        	String passwordKey = scan.nextLine();
	        	
	        	
	        try (Connection conn = DriverManager.getConnection(url, username, password)){
	            
	        	String sqlCommand = "insert into users (Login, PasswordKey) values (?, ?)";
	        	
	        	PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
	        	
	        	preparedStatement.setString(1, login);
	        	preparedStatement.setString(2, passwordKey);
	        		        	
	        	int rows = preparedStatement.executeUpdate();
	        	
	           System.out.printf("%d rows added", rows);
	           System.out.println();
	           System.out.println(" –еЇстрац≥€ пройшла усп≥шно!!!");
	           LogIn log = new LogIn();
	        }
	    }
	    catch(Exception ex){
	        System.out.println("Connection failed...");
	         
	        System.out.println(ex);
	    }
		
	}
	
}

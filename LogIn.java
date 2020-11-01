import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LogIn {

	public LogIn() {
		
		String Login = " ";
		String PasswordKey = " ";
		String login = " ";
		String passwordKey = " ";
		Scanner scan = new Scanner(System.in);
		
		try{
            String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
            String username = "root";
            String password = "11052013s";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                      
                try (Connection conn = DriverManager.getConnection(url, username, password)){
                	
               	 Statement statement = conn.createStatement();
                        
               	System.out.println("¬вед≥ть лог≥н: ");
               	login = scan.next();
               	System.out.println("¬вед≥ть пароль: ");
               	passwordKey = scan.next();
                    
               	ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE EXISTS (SELECT * FROM users WHERE login = '" + login + "' AND passwordKey = '" + passwordKey + "')");
                        
                        while(resultSet.next()){
                             
                     	   int id = resultSet.getInt(1);
                            Login = resultSet.getString(2);
                            PasswordKey = resultSet.getString(3);
                           
                        }
                        boolean result1 = Login.equalsIgnoreCase(login);
                        boolean result2 = PasswordKey.equalsIgnoreCase(passwordKey);
                        if (result1 == true || result2 == true) {
                        	ChoiceMenu choice = new ChoiceMenu();
                        }
                     }
               
                 }
         		
                 catch(Exception ex){
                     System.out.println("Connection failed...");
                      
                     System.out.println(ex);
                 }
		
	}
	
}

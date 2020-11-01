import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddFilmsDB {
    
	public AddFilmsDB() {
		
		
		
	try{
        String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
        String username = "root";
        String password = "11052013s";
        Scanner scan = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        
        	System.out.print("Введіть назву фільму: ");
        	String name = scan.nextLine();
        	
        	System.out.print("Введіть жанр фільму: ");
        	String genre = scan.nextLine();
        	
        	System.out.print("Введіть додатковий жанр фільму, або ENTER, щоб пропустити: ");
        	String alternativeGenre = scan.nextLine();
        	
        	System.out.print("Ведіть країну виробник, або ENTER, щоб пропустити: ");
        	String country = scan.nextLine();

        	System.out.print("Введіть рік випуску, або (0), щоб пропустити: ");
        	String years = scan.nextLine();
        	
        	System.out.print("Введіть посилання для перегляду онлайн, або (?), щоб пропустити: ");
        	String linkOnline = scan.nextLine();
        	
        	System.out.print("Введіть посилання для скачування, або (?), щоб пропустити: ");
        	String linkOffline = scan.nextLine();
        	
        	
        	
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            
        	String sqlCommand = "insert into films (NameFilms, Genre, AlternativeGenre, Country, Years, LinkOnline, LinkOffline) values (?, ?, ?, ?, ?, ?, ?)";
        	
        	PreparedStatement preparedStatement = conn.prepareStatement(sqlCommand);
        	
        	preparedStatement.setString(1, name);
        	preparedStatement.setString(2, genre);
        	preparedStatement.setString(3, alternativeGenre);
        	preparedStatement.setString(4, country);
        	preparedStatement.setString(5, years);
        	preparedStatement.setString(6, linkOnline);
        	preparedStatement.setString(7, linkOffline);
        	
        	int rows = preparedStatement.executeUpdate();
        	
           System.out.printf("%d rows added", rows);
           
        }
    }
    catch(Exception ex){
        System.out.println("Connection failed...");
         
        System.out.println(ex);
    }
}
}

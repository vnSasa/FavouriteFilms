import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class All {

	public All() {
	
		try{
            String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
            String username = "root";
            String password = "11052013s";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
             
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                 
               Statement statement = conn.createStatement();
               
               ResultSet resultSet = statement.executeQuery("SELECT * FROM films");
                   
                   while(resultSet.next()){
                        
                	   int id = resultSet.getInt(1);
                       String NameFilms = resultSet.getString(2);
                       String Genre = resultSet.getString(3);
                       String AlternativeGenre = resultSet.getString(4);
                       String Country = resultSet.getString(5);
                       String Years = resultSet.getString(6);
                       String LinkOnline = resultSet.getString(7);
                       String LinkOffline = resultSet.getString(8);
                       System.out.println(id+". "+NameFilms+" - "+Genre+", "+AlternativeGenre+" ("+Country+", "+Years+" рік), подивитись онлайн - "+LinkOnline+", завантажити - "+LinkOffline);
                   
                   		}
               
            	}
      
        }
		
        catch(Exception ex){
            System.out.println("Connection failed...");
             
            System.out.println(ex);
        }
	}	
}

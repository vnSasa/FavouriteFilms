import java.sql.*;
import java.util.Scanner;

public class ViewFilms {

	String type = " ";
    String var = " ";
	
	public ViewFilms() {
		
		
        		
		System.out.println("Оберіть вид перегляду: (1) - Все; (2) - За жанровими ознаками; (3) - По країні виробнику; (4) - По року випуску.");
               Scanner scan = new Scanner(System.in);
               int choice = scan.nextInt();
               
              if (choice == 1) { All all = new All(); }
              
              else if (choice == 2 || choice == 3 || choice == 4) 
              { 
            	  switch (choice) 
            	  {
            	  case 2: {
            		  type = "Genre";
            		  System.out.println("Введіть жанрові, якиі вас цікавлять: ");
            		  var = scan.next();
            		  break;
            	  }
            	  
            	  case 3: {
            		  type = "Country";
            		  System.out.print("Введіть назву країни: ");
            		  var = scan.next();
            		  break;
            	  }
            	  
            	  case 4: {
            		  type = "Years";
            		  System.out.print("Введіть рік випуску: ");
            		  var = scan.next();
            		  break;
            	  }
            	  
            	  default: {
            		  System.out.println("Зроблено не коректний вибір. Перезапустіть програму.");
            	  	}
            	  }
            	  
         try{
             String url = "jdbc:mysql://localhost/favouritefilms?serverTimezone=Europe/Kiev&useSSL=false";
             String username = "root";
             String password = "11052013s";
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                       
                 try (Connection conn = DriverManager.getConnection(url, username, password)){
                           
                	 Statement statement = conn.createStatement();
                         
                     ResultSet resultSet = statement.executeQuery("SELECT * FROM films WHERE " + type +  " = '" + var + "'");
                         
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
}

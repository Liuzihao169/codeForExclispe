package jdbctuils.web1;

import java.sql.Connection;

public class textDemo {
   public static void main(String []args){
	   Connection con=jdbcu.getconnection();
	   System.out.println(con);
   }
}

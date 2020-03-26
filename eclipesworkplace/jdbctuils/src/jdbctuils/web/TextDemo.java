package jdbctuils.web;

import java.sql.Connection;

public class TextDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Connection con=TextUtils.getconnection();
      System.out.println(con);
      System.out.println("yy");
	}
}

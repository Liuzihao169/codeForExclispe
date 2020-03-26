package jdbctuils.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MydataSourceDemo {
      public static void main(String []args) throws SQLException{
    	  	MydataSouse mysouse=new MydataSouse();
    	 Connection con=mysouse.getConnection();
    	 System.out.println(con);
    	 String sql="select * from stu";
    	  PreparedStatement pst=con.prepareStatement(sql);
    	  ResultSet rs=pst.executeQuery();
while(rs.next()){
    		  System.out.println( rs.getInt("id")+rs.getString("name")+rs.getString("gender"));
    		  
    	  }
    	  mysouse.backConnection(con);
      }
}

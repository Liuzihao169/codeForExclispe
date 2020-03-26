package utilspropertise;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
       //private static ComboPooledDataSource datasouse= new ComboPooledDataSource();
       public static DataSource getDataSource(){
    	   return    new   ComboPooledDataSource();
       }
       public static Connection getconnection(){
    	          try {
					return getDataSource().getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				   throw new RuntimeException(e);
				}
       }
}

package checkdemo;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import day17.demo.domin.Product;
import utils.C3p0Utils;

public class Dmeo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
       QueryRunner qy=new QueryRunner(C3p0Utils.getDataSource());
       String sql="select * from product where pid='13'";
      Product pro= qy.query(sql, new BeanHandler<Product>(Product.class));
      System.out.println(pro);
	}

}

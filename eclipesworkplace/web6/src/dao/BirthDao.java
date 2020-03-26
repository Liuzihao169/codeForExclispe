package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import daomain.customer;
import utils.DataSourceUtils;

public class BirthDao {

	public List<customer> selectbir(String birty) {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="SELECT *FROM customer WHERE DATA LIKE ?";
		try {
			List<customer>list=qy.query(sql, new BeanListHandler<customer>(customer.class), "%"+birty);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	     throw new  RuntimeException(e);
					}
				}
		

}

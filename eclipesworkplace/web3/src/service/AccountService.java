package service;



import java.sql.Connection;
import java.sql.SQLException;

import dao.Accountdao;
import utils.C3p0Utils;

public class AccountService {
      Accountdao accountdao=new Accountdao();
	public void transfer(String out, String in, double money){
		boolean flog=true;
	
		// TODO Auto-generated method stub
		Connection con=null;
		
	 con=C3p0Utils.getconnection();
//		try {
//			con.setAutoCommit(false);
			try {
				//accountdao.transferout(con,out,money);
				accountdao.transferint(con,in,money);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				flog=false;
			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
			
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}finally{
//			try {
//				con.commit();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return flog;
		
	}}

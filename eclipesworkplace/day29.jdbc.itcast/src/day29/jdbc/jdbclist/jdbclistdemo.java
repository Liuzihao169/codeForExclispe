package day29.jdbc.jdbclist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import day29.jdbc.jdbclist.sort.Student;
import day29.jdbc.jdbcutil.JDBCutile;

public class jdbclistdemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection con=JDBCutile.getconnection();
		 String sql="SELECT * FROM student";
		 PreparedStatement pst=con.prepareStatement(sql);
		 List<Student>list=new ArrayList<Student>();
		 ResultSet rs=pst.executeQuery();
		 while(rs.next()){
			 Student stu=new Student(rs.getInt("id"),rs.getString("studentname"),rs.getInt("grade") );
		    list.add(stu);
		 }
		Iterator<Student>it= list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("-----ÔöÇ¿for---------");
		for(Student stu:list){
			System.out.println(stu);
			
		}

	}

}

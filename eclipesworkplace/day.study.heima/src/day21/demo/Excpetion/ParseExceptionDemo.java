package day21.demo.Excpetion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		founction();
		}catch(ParseException ex){
			System.out.println(ex);
			
		}

	}
	public static void founction() throws ParseException{
		SimpleDateFormat stf=new SimpleDateFormat("yyy-MM-dd");
		Date day=stf.parse("2018-6-6");
		System.out.println(day);
		
	}

}

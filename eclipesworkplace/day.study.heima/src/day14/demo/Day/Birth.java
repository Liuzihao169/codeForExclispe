package day14.demo.Day;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Birth {
 public static void main(String[]args) throws ParseException{
	 String myBirth="1998��3��23��";
	 String today="2018��5��10��";
	 SimpleDateFormat st=new SimpleDateFormat ("yyyy��MM��dd��");
	 Date date=st.parse(today);
	 Date date1=st.parse(myBirth);
	long min=date.getTime()-date1.getTime();
	System.out.println(min/(1000*60*60*24));
	 
	 
	 
 }
}

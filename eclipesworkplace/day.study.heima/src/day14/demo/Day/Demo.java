package day14.demo.Day;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Date data=new Date();
	System.out.println(data);
	System.out.println(new Date(0));
	System.out.println(new Date(1));
	SimpleDateFormat sft=new SimpleDateFormat("yyyy_M_dd_hh_mm_ss");//格式化时间输出
	System.out.println(sft.format(data));

	}

}

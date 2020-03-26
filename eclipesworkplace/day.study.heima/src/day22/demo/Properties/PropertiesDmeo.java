package day22.demo.Properties;

import java.util.Properties;

public class PropertiesDmeo {
  public static void main(String[]args){
	  Properties pro=new Properties();
      pro.setProperty("大毛", "一年级"); 
      pro.setProperty("二毛", "二年级");
      System.out.println(pro.getProperty("大毛"));
      System.out.println(pro);
  }
}

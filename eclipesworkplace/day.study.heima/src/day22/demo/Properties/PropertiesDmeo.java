package day22.demo.Properties;

import java.util.Properties;

public class PropertiesDmeo {
  public static void main(String[]args){
	  Properties pro=new Properties();
      pro.setProperty("��ë", "һ�꼶"); 
      pro.setProperty("��ë", "���꼶");
      System.out.println(pro.getProperty("��ë"));
      System.out.println(pro);
  }
}

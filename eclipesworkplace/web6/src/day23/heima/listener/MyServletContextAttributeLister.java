package day23.heima.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeLister implements ServletContextAttributeListener{
//Ìí¼Ó
	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
		
	}
//É¾³ý
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
	}
//ÐÞ¸Ä
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		// TODO Auto-generated method stub
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
	}

}

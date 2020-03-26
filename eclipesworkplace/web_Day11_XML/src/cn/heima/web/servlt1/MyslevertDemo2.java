package cn.heima.web.servlt1;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyslevertDemo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
         SAXReader saxr=new SAXReader();
         Document doc=saxr.read("src/cn/heima/web/servlt1/web.xml");
         Element rootele=doc.getRootElement();
        // System.out.println(rootele.getName());
         Element servltele=rootele.element("servlet");
        System.out.println(servltele);
        Element servletclass=servltele.element("servlet-class");
         String classnaem=servletclass.getText();
         System.out.println(classnaem);
         Class clazz=Class.forName(classnaem);
         Myslevet1 m1=(Myslevet1) clazz.newInstance();
         m1.init();
         m1.servic();
         m1.destory();
//         
	}

}

package cn.heima.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo4j {
	public  static void main(String[]arrgs) throws DocumentException{
		//��ȡ������
		SAXReader saxr=new SAXReader();
		//��ȡxml��Դ
		Document doc=saxr.read("src/cn/heima/xml/dom4j/web.xml");
	    Element rootele=doc.getRootElement();
	    System.out.println(rootele.getName());
	    String value=rootele.attributeValue("version");
	    System.out.println(value);
	    List<Element>ElementList=rootele.elements();
	    for(Element ele:ElementList){
	    	System.out.println(ele.getName());
	    	List<Element>childList=ele.elements();
	    	for(Element es:childList){
	    	String childelementname=es.getName();
	    	System.out.print(childelementname+es.getText()+"\t\t\t");
	    	}
	    	System.out.println("");
	    }
		
	}

}

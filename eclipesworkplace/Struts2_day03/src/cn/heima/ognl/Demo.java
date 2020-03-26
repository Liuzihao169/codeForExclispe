package cn.heima.ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.heima.bean.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class Demo {
	@Test
	public void fun1() throws OgnlException{
		 User u1=new User("jack",19);
		 User u2=new User("rose",18);
		 OgnlContext oc=new OgnlContext();
		 oc.setRoot(u1);
		 Map<String,User>map=new HashMap<String,User>();
		 map.put("u1", u1);
		 map.put("u2", u2);
		 oc.setValues(map);
		 // 直接取属性的名字
		 String value = (String)Ognl.getValue("name", oc, oc.getRoot());
		 System.out.println(value);
		 //如果去context中的值应该#+map中key的值.属性
		 String value2=(String) Ognl.getValue("#u2.name='hha' ,#u2.name", oc, oc.getRoot());
		 System.out.println(value2);
	}

}

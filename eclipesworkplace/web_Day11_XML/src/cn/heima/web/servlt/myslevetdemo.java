package cn.heima.web.servlt;

import java.lang.reflect.Method;

public class myslevetdemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
           Class cs=Class.forName("cn.heima.web.servlt.Myslevet");
          Object obj=cs.newInstance();
           Method md=cs.getMethod("init");
           Method md1=cs.getMethod("servic");
           Method md2=cs.getMethod("destory");
           md.invoke(obj);
           md1.invoke(obj);
           md2.invoke(obj);
          
	}

}


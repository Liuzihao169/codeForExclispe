package day25.Proxy.target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class Proxttext {
 @Test
 		public void text(){
	      
	 //获得动态代理
	 Targetintetfence obj =(Targetintetfence) Proxy.newProxyInstance(
				Target.class.getClassLoader(), 
				new Target().getClass().getInterfaces(), 
				//new Class[]{Targetintetfence.class},
				new InvocationHandler(){//实际要调用的方法
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					// TODO Auto-generated method stub/*
					
					
					/*invoke 是代表执行代理对象的方法
					 * 1.method 代表目标对象的字节码对象
					 * 2.args代表目标方法的参数*/
					System.out.println("我是代理");
					//执行目标对象方法
					 method.invoke(new Target(), args);
					return null;
				}});    
	 				
	         obj.mehtod1("niiubi");//调用实现同一接口的代理的方法，
	 
		 }
		}

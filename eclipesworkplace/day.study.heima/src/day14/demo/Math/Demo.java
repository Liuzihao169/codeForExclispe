package day14.demo.Math;
import java.util.*;
public class Demo {
	public static void main(String []args){
		System.out.println(Math.PI);
		System.out.println(Math.abs(-20));//取绝对值
		System.out.println(Math.ceil(13.99));//取天花板
		System.out.println(Math.floor(25.66));//取地板
		System.out.println(Math.pow(2, 8));//指数，前面的数是底数，后面的数是指数
		System.out.println(Math.random());//生成0.0-1.0之间的随机数（包括0.0不包括2.0）
	    Random ri=new Random();
	    long start=System.currentTimeMillis();//定义开始的时间
		for(int i=0;i<100;i++){
		System.out.println(ri.nextInt(100)); 
		}
		long end=System.currentTimeMillis();//定义结束的时间
		System.out.println(end-start);//程序 运行的时间
		
		
		//arrayCopy复制数组的方法
		int [] arr={8,9,7,5,4};
		int [] arr1=arr;
		for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
		System.out.println("-----------");
		System.arraycopy(arr,0, arr1, 0, 3);
		for(int i=0;i<arr1.length;i++){
			System.out.println(arr1[i]);
			
		}
	}

}

package day14.demo.Math;
import java.util.*;
public class Demo {
	public static void main(String []args){
		System.out.println(Math.PI);
		System.out.println(Math.abs(-20));//ȡ����ֵ
		System.out.println(Math.ceil(13.99));//ȡ�컨��
		System.out.println(Math.floor(25.66));//ȡ�ذ�
		System.out.println(Math.pow(2, 8));//ָ����ǰ������ǵ��������������ָ��
		System.out.println(Math.random());//����0.0-1.0֮��������������0.0������2.0��
	    Random ri=new Random();
	    long start=System.currentTimeMillis();//���忪ʼ��ʱ��
		for(int i=0;i<100;i++){
		System.out.println(ri.nextInt(100)); 
		}
		long end=System.currentTimeMillis();//���������ʱ��
		System.out.println(end-start);//���� ���е�ʱ��
		
		
		//arrayCopy��������ķ���
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

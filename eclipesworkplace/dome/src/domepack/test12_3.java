package domepack;
import java.util.*;
public class test12_3{
	public static void main(String []ars){
		Scanner input=new Scanner(System.in);
		System.out.println("输入一个以零结尾的数值序列");
		ArrayList<Number>list=new ArrayList<>();
		int value;
		boolean md=true;
		while(md){
			value=input.nextInt();
			list.add(value);
			if(value==0){
				md=false;
			}
		}
		sort(list);
	}
 static void sort(ArrayList<Number>list){
	 Number maxnumber;
		for(int j=1;j<list.size();j++)
		for(int i=0;i<list.size()-j;i++){
			if(list.get(i).intValue()>list.get(i+1).intValue()){
				maxnumber=list.get(i+1);
				list.set(i+1,list.get(i) );
				list.set(i,maxnumber );
			}	
		}
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+"\t");
		}
				
	}
}

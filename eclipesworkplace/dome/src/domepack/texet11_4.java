package domepack;
import java.util.*;
public class texet11_4{
	public static void main(String []ars){
		Scanner input=new Scanner(System.in);
		System.out.println("输入一个以零结尾的数值序列");
		ArrayList<Integer>list=new ArrayList<>();
		int value;
		boolean md=true;
		while(md){
			value=input.nextInt();
			list.add(value);
			if(value==0){
				md=false;
			}
		}
		System.out.println(max(list));
	}
 static Integer max(ArrayList<Integer>list){
		int maxnumber=list.get(0);
		for(int i=0;i<list.size();i++){
			if(list.get(i)>maxnumber){
				maxnumber=list.get(i);
			}	
		}
		return maxnumber;
	}
}

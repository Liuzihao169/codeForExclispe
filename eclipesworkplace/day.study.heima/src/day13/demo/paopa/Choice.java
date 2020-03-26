package day13.demo.paopa;

public class Choice {
	public static void main(String [] args){
		int []arr={25,35,10,50};
		choice(arr);//直接调用方法
		print(arr);//直接调用方法
		
	}
public static void choice(int[]arr){
	for(int i=0;i<arr.length-1;i++){
		for(int j=i+1;j<arr.length;j++){
			if(arr[i]>arr[j]){
				 int temp=arr[j];
				 arr[j]=arr[i];
				 arr[i]=temp;
			}
		}
	}
}
 public static void print(int [] arr){
	 for(int i=0;i<arr.length;i++){
		 System.out.println(arr[i]);
	 }
	 
 }
}

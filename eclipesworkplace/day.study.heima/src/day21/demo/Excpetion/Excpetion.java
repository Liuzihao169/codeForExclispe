package day21.demo.Excpetion;

public class Excpetion {
	public static void main(String [] args) throws Exception{
		int[] arr1={};
		System.out.println(getArray(arr1));
		
	}
   public static int getArray(int[]arr) throws Exception{
	   if(arr==null){
		   throw new Exception("数组为空");
		   
	   }
	   if(arr.length==0){
		   throw new Exception("数组越界");
	   }
	   int i=arr[arr.length-1];
	   return i;
	   
   }
}

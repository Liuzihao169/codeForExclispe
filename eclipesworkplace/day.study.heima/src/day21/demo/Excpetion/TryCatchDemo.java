package day21.demo.Excpetion;

public class TryCatchDemo { 
	public static void main(String[]args){
		int[]arr=null;
		int[]arr1={1,2};
		try{
		//int i=getArry(arr);//
		int j=getArry(arr1);
		//System.out.println(i);
		System.out.println(j);
		
		}catch(NullPointerException ex){
			System.out.println(ex);
			
		}
		catch(ArrayIndexOutOfBoundsException et){
			System.out.println(et);
		}
		
		System.out.println("Game Over");
		
		
	}
	public static int  getArry(int[]arr)throws NullPointerException,ArrayIndexOutOfBoundsException{
		if(arr==null){
		throw new  NullPointerException("���鲻����");
			
		}
		if(arr.length<3){
			throw new ArrayIndexOutOfBoundsException("����Խ��");
		}
		return arr[3];
	}

}

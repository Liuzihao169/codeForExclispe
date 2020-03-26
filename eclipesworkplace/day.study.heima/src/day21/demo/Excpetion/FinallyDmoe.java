package day21.demo.Excpetion;

public class FinallyDmoe {
  public static void main(String []args){
	  int a=1;
	  try{
	  founction(a);
	  }catch(Exception ex){
             System.out.println(ex);		  
	  }finally{
		  System.out.println("这条代码一定会执行");
	  }
	  
  }
  public static void founction(int a)throws Exception{
	  if(a==1){
		  throw new Exception("异常等于一");
	  }
  }
}

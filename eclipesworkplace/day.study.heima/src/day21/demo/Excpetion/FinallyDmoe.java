package day21.demo.Excpetion;

public class FinallyDmoe {
  public static void main(String []args){
	  int a=1;
	  try{
	  founction(a);
	  }catch(Exception ex){
             System.out.println(ex);		  
	  }finally{
		  System.out.println("��������һ����ִ��");
	  }
	  
  }
  public static void founction(int a)throws Exception{
	  if(a==1){
		  throw new Exception("�쳣����һ");
	  }
  }
}

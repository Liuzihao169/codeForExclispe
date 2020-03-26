package demotexe;

public class People {
    int age;
    String name;
    String gender;

   public void showinof(){
	  System.out.println("身份信息......");
	  System.out.println("age"+age);
	  System.out.println("name"+name);
	  System.out.println("gender"+gender); 
   }
   public People(int A_age,String N_name,String G_gender ){
	   age=A_age;
	   name=N_name;
	   gender=G_gender; 
   }
   public People(){
	   
   }
   public People( int A_age){
	   age=A_age;
	   
   }
   
}
package day19.demo.Set;

public class People {
   private  String name;
   private int age;
   public  int hashCode(){
	   return name.hashCode()+age;
	   }
   public boolean equals(Object obj){
	   if(this==obj){
		   return true;
	   }
	   if(obj==null){
		   return false;
	   }
	   if(obj instanceof People){
		   People p=(People)obj;
		   if(name.equals(p.name)&&age==p.age){
			   return true;		   }
	   }
	   return false;
   }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public People(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
   public People(){
	   
   }
@Override
public String toString() {
	return "age:---+"+age+"name:+"+name;
}
}

package demotexe.demo1;

public class People{
	String name;
	Data birthday;

public People(String name,Data birthday){
	this.name=name;
	this.birthday=birthday;
}
public People(){
	birthday=new Data();//为空
	
}
public void show(){
	System.out.println("人的基本信息---------");
    System.out.println("姓名"+name);
    System.out.print("出生日期：");
    birthday.showinfo();
}
}
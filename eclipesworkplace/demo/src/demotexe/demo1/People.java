package demotexe.demo1;

public class People{
	String name;
	Data birthday;

public People(String name,Data birthday){
	this.name=name;
	this.birthday=birthday;
}
public People(){
	birthday=new Data();//Ϊ��
	
}
public void show(){
	System.out.println("�˵Ļ�����Ϣ---------");
    System.out.println("����"+name);
    System.out.print("�������ڣ�");
    birthday.showinfo();
}
}
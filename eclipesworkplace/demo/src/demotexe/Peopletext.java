package demotexe;

public class Peopletext {
	public static void main(String []Args){
		People p1=new People();//系统默认的无参构造方法没了，要自己构建
		p1.age=18;
		p1.gender="男";
		p1.name="于大海";
		p1.showinof();
		People p2=new People(17,"大毛","男");
		p2.showinof();
		People p3=new People(17);
		p3.showinof();
	}

}

package demotexe;

public class Peopletext {
	public static void main(String []Args){
		People p1=new People();//ϵͳĬ�ϵ��޲ι��췽��û�ˣ�Ҫ�Լ�����
		p1.age=18;
		p1.gender="��";
		p1.name="�ڴ�";
		p1.showinof();
		People p2=new People(17,"��ë","��");
		p2.showinof();
		People p3=new People(17);
		p3.showinof();
	}

}

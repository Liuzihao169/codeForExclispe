package day1.demo.interfaces.news;
public class Demo {
	public static void main(String[]Args){
		/*SporPage p1=new SporPage();
		Indexpage i1=new Indexpage();
		p1.addNeews();
		p1.deletNeews();
		i1.addNeews();
		i1.deletNeews();//注释是灰色的看不清楚*/
		IDao idao=new Dbc();
		Indexpage i1=new Indexpage(idao);
		i1.addNeews();
		i1.deletNeews();
		i1.idao=new Mysql();
		i1.addNeews();
		i1.deletNeews();
	}

}

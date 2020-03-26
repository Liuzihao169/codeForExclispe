package demotexe.demo1;
//年 月  日
public class Data {
	int mouth;
	int year;
	int day;
public Data(){
	}
public Data(int mouth,int year,int day){
	this.mouth=mouth;
	this.year=year;
	this.day=day;
   }
public void showinfo(){
	System.out.println(year+"年"+mouth+"月"+day+"日");
}
   }

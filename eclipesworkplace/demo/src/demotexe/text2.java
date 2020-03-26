package demotexe;

public class text2 {
    public static void main(String[]args){
    	Car car1=new Car();
    	Enger enger1=new Enger();
    	car1.color="红色";
    	car1.name="兰博基尼";
    	enger1.power=2;
    	car1.carenger=enger1;//装上发动机
    	car1.showcar();
    	car1.start();
    	car1.stop();
    	
    }
}

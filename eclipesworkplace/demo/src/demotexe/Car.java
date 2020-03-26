package demotexe;

public class Car {
	String name;
	String color;
	Enger carenger;

    public void start(){
	    System.out.println("小汽车启动");
	    carenger.stop();
	  
    }
    public void stop(){
	    System.out.println("小汽车停止");
	    carenger.start();
    }
    public void showcar(){
    	System.out.println("车辆信息-----------");
    	System.out.println("name:"+name);
    	System.out.println("color"+color);
    	System.out.println("pow:"+carenger.power);
    }
    } 
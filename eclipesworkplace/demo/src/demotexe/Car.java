package demotexe;

public class Car {
	String name;
	String color;
	Enger carenger;

    public void start(){
	    System.out.println("С��������");
	    carenger.stop();
	  
    }
    public void stop(){
	    System.out.println("С����ֹͣ");
	    carenger.start();
    }
    public void showcar(){
    	System.out.println("������Ϣ-----------");
    	System.out.println("name:"+name);
    	System.out.println("color"+color);
    	System.out.println("pow:"+carenger.power);
    }
    } 
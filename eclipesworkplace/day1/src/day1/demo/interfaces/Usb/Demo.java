package day1.demo.interfaces.Usb;

public class Demo {
	public static void main(String[]args){
		Computer com1=new Computer();//生产一个电脑
		Mouth m1=new Mouth();//先要有一个鼠标
		com1.Setusb(m1);//把鼠标插到电脑上
		com1.UsbDevicework();//鼠标工作开始
		Keybord keyb1=new Keybord();
		com1.Setusb(keyb1);
		com1.UsbDevicework();
		
		
		
		
	}

}

package day1.demo.interfaces.Usb;

public class Demo {
	public static void main(String[]args){
		Computer com1=new Computer();//����һ������
		Mouth m1=new Mouth();//��Ҫ��һ�����
		com1.Setusb(m1);//�����嵽������
		com1.UsbDevicework();//��깤����ʼ
		Keybord keyb1=new Keybord();
		com1.Setusb(keyb1);
		com1.UsbDevicework();
		
		
		
		
	}

}

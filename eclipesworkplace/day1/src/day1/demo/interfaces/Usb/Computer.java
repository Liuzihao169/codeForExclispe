package day1.demo.interfaces.Usb;

public class Computer {
	private Usb usb;
	public void Setusb(Usb usb){
		this.usb=usb;
	}
	//ģ�������Usb���������
	public void UsbDevicework(){
		usb.work();
	}
}

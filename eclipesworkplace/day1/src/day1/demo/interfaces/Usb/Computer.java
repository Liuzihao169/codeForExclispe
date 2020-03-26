package day1.demo.interfaces.Usb;

public class Computer {
	private Usb usb;
	public void Setusb(Usb usb){
		this.usb=usb;
	}
	//模拟电脑上Usb工作的情况
	public void UsbDevicework(){
		usb.work();
	}
}

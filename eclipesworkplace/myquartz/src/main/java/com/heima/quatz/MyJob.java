package com.heima.quatz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob {
	/*
	 * 
	 * ����һ����ʱ����
	 */
	public void run(){
		System.out.println("��ʼ��ʱ����"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}

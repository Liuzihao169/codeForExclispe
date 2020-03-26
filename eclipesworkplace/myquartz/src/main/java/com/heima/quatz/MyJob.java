package com.heima.quatz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob {
	/*
	 * 
	 * 这是一个定时任务
	 */
	public void run(){
		System.out.println("开始定时任务"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
}

package emila;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import daomain.customer;
import service.Servicebirth;

public class birthday implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("服务器创建");
		SimpleDateFormat Format=new SimpleDateFormat("MM-dd");
		 String birty=Format.format(new Date());
		Timer time=new Timer();
		Servicebirth servicebirty=new Servicebirth();
		time.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			System.out.println("进入ruanner");
				List<customer>list=servicebirty.selectbir(birty);
				System.out.println(list);
				System.out.println(birty);
				if(list.size()>0&&list!=null){
				for(customer cus:list){
					try {
						MilaUtils.sendMail(cus.getEmila(), "亲爱的"+cus.getName()+"祝你生日快乐");
						System.out.println(cus.getName()+"的邮件发送完毕");
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}}, new Date(), 1000*60);//执行的时间  开始的时间   时间的间隔
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	

}

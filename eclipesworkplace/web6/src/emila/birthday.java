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
		System.out.println("����������");
		SimpleDateFormat Format=new SimpleDateFormat("MM-dd");
		 String birty=Format.format(new Date());
		Timer time=new Timer();
		Servicebirth servicebirty=new Servicebirth();
		time.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			System.out.println("����ruanner");
				List<customer>list=servicebirty.selectbir(birty);
				System.out.println(list);
				System.out.println(birty);
				if(list.size()>0&&list!=null){
				for(customer cus:list){
					try {
						MilaUtils.sendMail(cus.getEmila(), "�װ���"+cus.getName()+"ף�����տ���");
						System.out.println(cus.getName()+"���ʼ��������");
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		}}, new Date(), 1000*60);//ִ�е�ʱ��  ��ʼ��ʱ��   ʱ��ļ��
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	

}

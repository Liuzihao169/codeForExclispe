package com.heima.service;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.heima.bos.entity.Workbill;
import com.heima.dao.WorkbillDao;
/**
 * �����ʼ�����ҵ
 * @author zhaoqx
 *
 */
public class MailJob {
	@Resource
	private WorkbillDao workbillDao;
	private String username;
	private String password;
	private String smtpServer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void execute() {
		System.out.println("Ҫ���ʼ��ˡ�����");
		try {
			//��ѯ��������Ϊ�µ������й���
			List<Workbill> list = workbillDao.findAll();
			if(null != list && list.size() > 0){
				final Properties mailProps = new Properties();
				mailProps.put("mail.smtp.host", this.getSmtpServer());
				mailProps.put("mail.smtp.auth", "true");
				mailProps.put("mail.username", this.getUsername());
				mailProps.put("mail.password", this.getPassword());

				// ������Ȩ��Ϣ�����ڽ���SMTP����������֤
				Authenticator authenticator = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						// �û���������
						String userName = mailProps.getProperty("mail.username");
						String password = mailProps.getProperty("mail.password");
						return new PasswordAuthentication(userName, password);
					}
				};
				// ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
				Session mailSession = Session.getInstance(mailProps, authenticator);
				for(Workbill workbill : list){
					// �����ʼ���Ϣ
					MimeMessage message = new MimeMessage(mailSession);
					// ���÷�����
					InternetAddress from = new InternetAddress(mailProps.getProperty("mail.username"));
					message.setFrom(from);
					// �����ռ���
					InternetAddress to = new InternetAddress("liuzihao_lzh@163.com");
					message.setRecipient(RecipientType.TO, to);
					// �����ʼ�����
					message.setSubject("ϵͳ�ʼ����µ�֪ͨ");
					// �����ʼ���������
					message.setContent(workbill.toString(), "text/html;charset=UTF-8");
					// �����ʼ�
					Transport.send(message);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}
}
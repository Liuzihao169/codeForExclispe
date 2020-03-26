package emila;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class testemila {
  public static void main(String []args) throws AddressException, MessagingException{
	  MilaUtils.sendMail("lucy@itheima.com", "lucy下午好，好久不见甚是想念");
	  
  }
}

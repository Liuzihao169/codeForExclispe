package demotexe;
import java.util.*;
public class Userlogic {
	public void login(){
		User user1=new User();
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("����������");
		String psw=sc.next();
		System.out.println("�������û���");
		String name=sc.next();
		
		user1.password=psw;
		user1.username=name;
		if(user1.logic()){
			System.out.println("�û���½�ɹ�");
			break;
		}
		else{
			System.out.println("�û���½ʧ��");
		}
	}	
}
}
package demotexe;
import java.util.*;
public class Userlogic {
	public void login(){
		User user1=new User();
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("请输入密码");
		String psw=sc.next();
		System.out.println("请输入用户名");
		String name=sc.next();
		
		user1.password=psw;
		user1.username=name;
		if(user1.logic()){
			System.out.println("用户登陆成功");
			break;
		}
		else{
			System.out.println("用户登陆失败");
		}
	}	
}
}
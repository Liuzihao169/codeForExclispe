package demotexe;

public class User {
String username;
String  password;
  public boolean logic(){
	  if("admin".equals(username)&&"123456".equals(password)){
	return true; 
	  }
	  else{
		return false;
	  }
	 
 }
}

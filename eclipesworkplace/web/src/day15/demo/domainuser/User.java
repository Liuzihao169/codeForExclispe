package day15.demo.domainuser;

public class User {
	private int id;
	private String username;
	private String password;
	private String emila;
	public User(int id, String username, String password, String emila) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emila = emila;
	}
	@Override
	public String toString() {
		return " id=" + id + ", username=" + username + ", password=" + password + ", emila=" + emila ;
	}
	public User(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmila() {
		return emila;
	}
	public void setEmila(String emila) {
		this.emila = emila;
	}
	

}

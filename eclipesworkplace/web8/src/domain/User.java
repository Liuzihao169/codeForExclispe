package domain;

public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", emila=" + emila + "]";
	}
	private int id;
	private String username;
	private String password;
	private String emila;
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

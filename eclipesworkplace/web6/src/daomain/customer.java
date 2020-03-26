package daomain;

public class customer {
 private String id;
 private String name;
 private String data;
 private String emila;
@Override
public String toString() {
	return "customer [id=" + id + ", name=" + name + ", data=" + data + ", emila=" + emila + "]";
}
public String getEmila() {
	return emila;
}
public void setEmila(String emila) {
	this.emila = emila;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
}

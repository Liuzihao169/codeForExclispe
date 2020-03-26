package day1.demo.Ispeaking;

public abstract class Animal implements Ispeaking {
	private Ispeaking ispeaking;
	public void setIspeaking(Ispeaking ispeaking) {
		this.ispeaking = ispeaking;
	}
	@Override
	public void speak(){
		ispeaking.speak();
	}
	

}

package day1.demo.interfaces.news;

public class Indexpage implements Inews {
	IDao idao;
	public Indexpage(IDao idao) {
		super();
		this.idao = idao;
	}

	@Override
	public void addNeews() {
		idao.addNeews();
		//System.out.println("����ҳ���������");
		// TODO Auto-generated method stub

	}

	@Override
	public void deletNeews() {
		idao.deletNeews();
		//System.out.println("��������ɾ������");
		// TODO Auto-generated method stub

}
}
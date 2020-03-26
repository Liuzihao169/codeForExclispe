package day1.demo.interfaces.news;

public class SporPage implements Inews {
     IDao idao;
     
	public SporPage(IDao idao) {
		super();
		this.idao = idao;
	}

	@Override
	public void addNeews() {
		idao.addNeews();
		//System.out.println("在体育页面添加新闻");
		// TODO Auto-generated method stub

	}

	@Override
	public void deletNeews() {
		idao.deletNeews();
		//System.out.println("在体育界面删除新闻");
		// TODO Auto-generated method stub

	}

}

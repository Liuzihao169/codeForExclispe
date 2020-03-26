package day1.demo.interfaces.news;

public class Dbc implements IDao{

	@Override
	public void deletNeews() {
		System.out.println("这是在Dbc数据库中删除");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNeews() {
		System.out.println("这是在Dbc数据库中添加");
		// TODO Auto-generated method stub
		
	}

}

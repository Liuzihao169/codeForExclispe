package cn.heima.web.servlt;

public class Myslevet implements Imyslevet {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("我来啦 ");

	}

	@Override
	public void servic() {
		// TODO Auto-generated method stub
		System.out.println("我来为你服务");
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
       System.out.println("....我走了");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

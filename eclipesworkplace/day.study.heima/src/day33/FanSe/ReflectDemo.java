package day33.FanSe;

public class ReflectDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
       People  p=new People();//对象获取
       Class c=p.getClass();
   System.out.println(c);
   /*
    * 2.类直接获取，通过类获取
    **/
  System.out.println(People.class);
  Class c3=Class.forName("day33.FanSe.People");
  System.out.println(c3);
	}

}

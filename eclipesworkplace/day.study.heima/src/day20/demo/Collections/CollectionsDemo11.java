package day20.demo.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo11 {
	public static void main(String[]Args){
		founction();
	}

	private static void founction() {
		// TODO Auto-generated method stub
		List<String>list=new ArrayList<String>();
	    list.add("���Ӻ�");
	    list.add("�׻���");
	    System.out.println(list);
	    System.out.println("----------------------");
		Collections.sort(list);
		System.out.println(list);
	}

}

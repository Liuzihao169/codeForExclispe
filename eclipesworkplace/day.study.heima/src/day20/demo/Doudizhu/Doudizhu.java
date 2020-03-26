package day20.demo.Doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Doudizhu {

	
	 /* 
	  * 组合牌
	  *  洗牌
	           发牌
	           看牌
	       */
	public static void main(String[]args){
		HashMap<Integer,String>pooker=new HashMap<Integer,String>();
		//存储编号的数字，shuffle
		ArrayList<Integer>Pookernumbers=new ArrayList<Integer>();
		String[]numbers={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		String[]color={"♠","♣","♥","♦"};
		Integer index=2;
		for(String number:numbers){
			for(String colors:color){
		pooker.put(index, number+colors);
		Pookernumbers.add(index);
		index++;	
			}
		}
		pooker.put(0, "大王");
		Pookernumbers.add(0);
		pooker.put(1, "小王");
		Pookernumbers.add(1);
		System.out.println(pooker);
		//洗牌
		Collections.shuffle(Pookernumbers);
		//发牌
		ArrayList<Integer>Play1=new ArrayList<Integer>();
		ArrayList<Integer>Play2=new ArrayList<Integer>();
		ArrayList<Integer>Play3=new ArrayList<Integer>();
		ArrayList<Integer>botton=new ArrayList<Integer>();
		//采用的是集合的索引%3
		for(int i=0;i<Pookernumbers.size();i++){
			if(i<3){
				botton.add(Pookernumbers.get(i));
			}
			if(i%3==0){
				Play1.add(Pookernumbers.get(i));
			}
			else if(i%3==1){ 
				Play2.add(Pookernumbers.get(i));
			}
			else if(i%3==2){
				Play3.add(Pookernumbers.get(i));
			}
			
		}
		//看牌
		Collections.sort(Play1);//底牌排序
		Collections.sort(Play2);
		Collections.sort(Play3);
		look("旺达",Play1,pooker);
		look("阿纲",Play2,pooker);
		look("小富",Play3,pooker);
		look("底牌",botton,pooker);
		
		
	}
	 static void look (String name,ArrayList<Integer>play,HashMap<Integer,String>map){
		 System.out.println(name);
		 for(Integer key:play){
			System.out.print(map.get(key)+"  ");
		}
		 System.out.println("");
		
	}
	
}

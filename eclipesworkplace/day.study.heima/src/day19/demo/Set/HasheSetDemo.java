package day19.demo.Set;

import java.util.HashSet;

public class HasheSetDemo {
    public static void main(String[]args){
/*    	Set <String>myset=new HashSet <String>();
    	myset.add("cc");
    	myset.add("cd");
    	myset.add("cv");
    	myset.add("cs");
    	myset.add("cx");
    	myset.add("ct");
    	Iterator <String>it=myset.iterator();
    	while(it.hasNext()){
    		System.out.println(it.next());
    		
    	}
    	System.out.println(myset.hashCode());*/
    HashSet<People>hash=new HashSet<People>();
    hash.add(new People("liu",15));
    hash.add(new People("liu",15));
    hash.add(new People("lj",14));
    hash.add(new People("lk",14));

   System.out.println(hash);
    	
    } 
}

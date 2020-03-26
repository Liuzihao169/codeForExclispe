package jj;
import java.util.*;
public class guss{
    public static void main(String[]args){   
 Scanner in=new Scanner(System.in);
 int person;
    int number=(int)(Math.random()*101);
  do{System.out.println("亲╭(╯3╰)╮！猜一猜电脑所产生的随机数！(0-100)");
   person=in.nextInt();
  if(person<number){System.out.println("不好意思小了一点,再试一下");    
  }
   else if(person>number)  {
       System.out.println("有点大了，再输入一下@_@");
   }    
  }  
    while(person!=number);
    System.out.println("哎呀！妈呀！太厉害了!猜对了?*^_^");
    
    
    }
    
    
    
    
}
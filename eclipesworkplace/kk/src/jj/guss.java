package jj;
import java.util.*;
public class guss{
    public static void main(String[]args){   
 Scanner in=new Scanner(System.in);
 int person;
    int number=(int)(Math.random()*101);
  do{System.out.println("�רq(�s3�t)�r����һ�µ������������������(0-100)");
   person=in.nextInt();
  if(person<number){System.out.println("������˼С��һ��,����һ��");    
  }
   else if(person>number)  {
       System.out.println("�е���ˣ�������һ��@_@");
   }    
  }  
    while(person!=number);
    System.out.println("��ѽ����ѽ��̫������!�¶���?*^_^");
    
    
    }
    
    
    
    
}
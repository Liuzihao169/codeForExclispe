package jj;
import java.util.*;
public class classaction {
	public static void main (String[]arges){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入学生人数");
		int person=in.nextInt();
		String[]name=new String[person];//声明学生姓名的数组
		for (int i=0;i<name.length;i++){
			System.out.println("请输入第"+(i+1)+"名学生的名字");
			name[i]=in.next();//接收名字
		}//以此输入相应的名字

		System.out.println("请输入科目数");
		int jobnumber=in.nextInt();     //接收科目的数
		String []jobname=new String[jobnumber]   ;  //声明功课的数组
		String[] str=new String[person];   //排序整个字符串数组
		for (int j=0;j<jobname.length;j++){
			System.out.println("请定义第"+(j+1)+"门功课");
			jobname[j]=in.next();	
		}   //接收定义的功课
		String still="";  //声明一个字符串
		int[]avg=new int[person];  //声明平均分的数组
		int s=0;
		int [][]biaoge=new int [person][jobnumber];
		int[]zong=new int[person];
		for(int i=0;i<person;i++){
			for(int j=0;j<jobnumber;j++){
				System.out.println("请输入"+name[i]+"的"+jobname[j]+"成绩");
				biaoge[i][j]=in.nextInt();//接收分数
				s+=biaoge [i][j];//累加求总分
				still+=biaoge[i][j]+"\t";

			}

			zong[i]=s;	
			avg[i]=s/person;//平均分
			str[i]=name[i]+"\t"+still+avg[i]+"\t"+zong[i];//将其一行弄成一个字符，可以方串便比较
		}	
		for (int i=0;i<zong.length-1;i++){
			for(int j=0;j<zong.length-1;j++){
				if(zong[j]<zong[j+1]){
					int t=zong[j]; String t2=str[j];
					zong[j]=zong[j+1];str[j]=str[j+1];
					zong[j+1]=t;str[j+1]=str[j];//排序
				}


			}

		}
		System.out.print("学生");	
		for(int i=0;i<jobnumber;i++){
			System.out.print("\t"+jobname[i])	;//输出  学生  科目  科目 科目  平均分 总分 名次的版面
		}
		System.out.print("\t平均分\t总分\t名次");
		System.out.print("\n");
		for(int i=0;i<person;i++){
			System.out.println(str[i]+"\t"+"第"+(i+1)+"名");//将整合的字符串数组按顺序输出
		}


	}
}


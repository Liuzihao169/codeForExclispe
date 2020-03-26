package cn.itcast.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.contorller.ZhangWuContorller;
import cn.itcast.gjp.domain.Zhangwu;

public class MainView {
	private ZhangWuContorller contorller=new ZhangWuContorller();
    public void run(){
    	Scanner sc=new Scanner(System.in);
    	while(true){
    		System.out.println("----------------管家婆记账软件----------");
    		System.out.println("1.添加账务   2.编辑账务   3.删除账务   4.查询账务  5.退出系统");
    		System.out.println("请输入要操作的功能序号【1-5】");
    		int choose=sc.nextInt();
    		switch(choose){
    		//添加账务
    		case 1:addZhangwu();
    			break;
    	    //编辑账务
    		case 2:editZhangwu();
    			break;
    		//删除账务
    		case 3:deleteZhangwu();
    			break;	
    		//查询账务
    		case 4:selectZhangWu(); 
    			break;
    		//退出系统
    		case 5:
    			System.exit(0);
    			break;	
    		}
    	}
    	
    }
    public void selectZhangWu(){
    	System.out.println("1.查询所有  2.条件查询");
    	Scanner sc=new Scanner(System.in);
    	int selectchooser=sc.nextInt();
    	switch(selectchooser){
    	case 1:
    		selectAll();
    		break;
    	case 2:
    		select1();
    	break;
    	}
    }
    public void deleteZhangwu(){
    	Scanner sc=new Scanner(System.in);
    	System.out.println("现在执行的删除账务功能");
    	selectAll();
    	System.out.println("请输入你要删除的ID");
    int zwid=sc.nextInt();
    System.out.println("确认是否删除ID为"+zwid+"的账务（0.确认  1.取消）");
    	int flag=sc.nextInt();
    	if( flag==0){
    	contorller.deleteZhangwu(zwid);
    	System.out.println("恭喜！删除成功");
    	}
    }
    public void addZhangwu(){//添加账务
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.print("请输入消费类型：");
    	String flname=sc.next();
    	
    	System.out.print("请输入金额:");
    	double money=sc.nextDouble();
    	
    	System.out.print("请输入账户：");
    	String Zhanghu=sc.next();
    	
    	System.out.println("输入日期：（××××-××-××）");
    	String createtime=sc.next();
    	
    	System.out.print("请输入说明：");
    	String description =sc.next();
    	
    	Zhangwu zw=new Zhangwu(0,flname,money,Zhanghu,createtime,description);
    	  contorller.addZhangwu(zw);
    	  System.out.println("添加账务成功");
    	
    }
    //编辑账户
    public void editZhangwu(){
    	Scanner sc=new Scanner(System.in);
    	 System.out.println("现在执行的是编辑账务的功能");
    	 selectAll();
    	 System.out.println("请输入你要编辑的账户ID：");
    	 int zwid=sc.nextInt();
    	 System.out.println("请输入新的类别：");
    	 String flname=sc.next();
    	 System.out.println("请输入新的金额：");
    	 double money=sc.nextDouble();
    	 System.out.println("请输入新的账户：");
    	 String zhanghu=sc.next();
    	 System.out.println("请输入新的时间（××××-××-××）");
    	 String createtime=sc.next();
    	 System.out.println("请输入新的说明：");
    	 String description=sc.next();
    	 Zhangwu zw=new Zhangwu(zwid,flname,money,zhanghu,createtime,description);
    	contorller.editZhangwu(zw);
    	System.out.println("恭喜！财务编辑完成");
    }
    public void selectAll(){
    List<Zhangwu>list=contorller.selectAll();
    print(list);
   
    	
    }
    public void select(){//按照金额的范围查找
    	System.out.println("条件查找是按日期查找，请输入日期格式为××××-××-××");
    	Scanner sc=new Scanner(System.in);
    	System.out.print("请输入开始日期：");
    	String startData=sc.nextLine();
    	System.out.print("请输入结束日期：");
    	String endData=sc.nextLine();
    	List<Zhangwu>list=contorller.select( startData, endData);
    	if(list.size()!=0){
    	print(list);}
    	else System.out.println("没有查询到");}
    public void select_money(){
    	System.out.println("条件查找是按金额查找");
    	Scanner sc=new Scanner (System.in);
    	System.out.print("请输入金额的下限：");
    	Double min=sc.nextDouble();
    	System.out.print("请输入金额的上限：");
    	Double max=sc.nextDouble();
    	List<Zhangwu>list=contorller.select_money(min, max);
    	if(list.size()!=0){
        	print(list);}
        	else System.out.println("没有查询到");}
 
    public void select1(){
    	System.out.println("请选择查找的条件：1.日期 2.金额");
    	Scanner sc=new Scanner(System.in);
    	int chooserway=sc.nextInt();
    	switch(chooserway){
    	case 1:select();
    		break;
    	case 2:select_money();
    		break;
    	}
    	
    }
   
	private void print(List<Zhangwu> list) {
		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
        for(Zhangwu zw:list){
        	System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
        }
	}
    
}

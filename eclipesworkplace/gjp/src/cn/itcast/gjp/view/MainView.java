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
    		System.out.println("----------------�ܼ��ż������----------");
    		System.out.println("1.�������   2.�༭����   3.ɾ������   4.��ѯ����  5.�˳�ϵͳ");
    		System.out.println("������Ҫ�����Ĺ�����š�1-5��");
    		int choose=sc.nextInt();
    		switch(choose){
    		//�������
    		case 1:addZhangwu();
    			break;
    	    //�༭����
    		case 2:editZhangwu();
    			break;
    		//ɾ������
    		case 3:deleteZhangwu();
    			break;	
    		//��ѯ����
    		case 4:selectZhangWu(); 
    			break;
    		//�˳�ϵͳ
    		case 5:
    			System.exit(0);
    			break;	
    		}
    	}
    	
    }
    public void selectZhangWu(){
    	System.out.println("1.��ѯ����  2.������ѯ");
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
    	System.out.println("����ִ�е�ɾ��������");
    	selectAll();
    	System.out.println("��������Ҫɾ����ID");
    int zwid=sc.nextInt();
    System.out.println("ȷ���Ƿ�ɾ��IDΪ"+zwid+"������0.ȷ��  1.ȡ����");
    	int flag=sc.nextInt();
    	if( flag==0){
    	contorller.deleteZhangwu(zwid);
    	System.out.println("��ϲ��ɾ���ɹ�");
    	}
    }
    public void addZhangwu(){//�������
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.print("�������������ͣ�");
    	String flname=sc.next();
    	
    	System.out.print("��������:");
    	double money=sc.nextDouble();
    	
    	System.out.print("�������˻���");
    	String Zhanghu=sc.next();
    	
    	System.out.println("�������ڣ�����������-����-������");
    	String createtime=sc.next();
    	
    	System.out.print("������˵����");
    	String description =sc.next();
    	
    	Zhangwu zw=new Zhangwu(0,flname,money,Zhanghu,createtime,description);
    	  contorller.addZhangwu(zw);
    	  System.out.println("�������ɹ�");
    	
    }
    //�༭�˻�
    public void editZhangwu(){
    	Scanner sc=new Scanner(System.in);
    	 System.out.println("����ִ�е��Ǳ༭����Ĺ���");
    	 selectAll();
    	 System.out.println("��������Ҫ�༭���˻�ID��");
    	 int zwid=sc.nextInt();
    	 System.out.println("�������µ����");
    	 String flname=sc.next();
    	 System.out.println("�������µĽ�");
    	 double money=sc.nextDouble();
    	 System.out.println("�������µ��˻���");
    	 String zhanghu=sc.next();
    	 System.out.println("�������µ�ʱ�䣨��������-����-������");
    	 String createtime=sc.next();
    	 System.out.println("�������µ�˵����");
    	 String description=sc.next();
    	 Zhangwu zw=new Zhangwu(zwid,flname,money,zhanghu,createtime,description);
    	contorller.editZhangwu(zw);
    	System.out.println("��ϲ������༭���");
    }
    public void selectAll(){
    List<Zhangwu>list=contorller.selectAll();
    print(list);
   
    	
    }
    public void select(){//���ս��ķ�Χ����
    	System.out.println("���������ǰ����ڲ��ң����������ڸ�ʽΪ��������-����-����");
    	Scanner sc=new Scanner(System.in);
    	System.out.print("�����뿪ʼ���ڣ�");
    	String startData=sc.nextLine();
    	System.out.print("������������ڣ�");
    	String endData=sc.nextLine();
    	List<Zhangwu>list=contorller.select( startData, endData);
    	if(list.size()!=0){
    	print(list);}
    	else System.out.println("û�в�ѯ��");}
    public void select_money(){
    	System.out.println("���������ǰ�������");
    	Scanner sc=new Scanner (System.in);
    	System.out.print("������������ޣ�");
    	Double min=sc.nextDouble();
    	System.out.print("������������ޣ�");
    	Double max=sc.nextDouble();
    	List<Zhangwu>list=contorller.select_money(min, max);
    	if(list.size()!=0){
        	print(list);}
        	else System.out.println("û�в�ѯ��");}
 
    public void select1(){
    	System.out.println("��ѡ����ҵ�������1.���� 2.���");
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
		System.out.println("ID\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
        for(Zhangwu zw:list){
        	System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
        }
	}
    
}

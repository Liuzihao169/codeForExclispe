package jj;
import java.util.*;
public class classaction {
	public static void main (String[]arges){
		Scanner in=new Scanner(System.in);
		System.out.println("������ѧ������");
		int person=in.nextInt();
		String[]name=new String[person];//����ѧ������������
		for (int i=0;i<name.length;i++){
			System.out.println("�������"+(i+1)+"��ѧ��������");
			name[i]=in.next();//��������
		}//�Դ�������Ӧ������

		System.out.println("�������Ŀ��");
		int jobnumber=in.nextInt();     //���տ�Ŀ����
		String []jobname=new String[jobnumber]   ;  //�������ε�����
		String[] str=new String[person];   //���������ַ�������
		for (int j=0;j<jobname.length;j++){
			System.out.println("�붨���"+(j+1)+"�Ź���");
			jobname[j]=in.next();	
		}   //���ն���Ĺ���
		String still="";  //����һ���ַ���
		int[]avg=new int[person];  //����ƽ���ֵ�����
		int s=0;
		int [][]biaoge=new int [person][jobnumber];
		int[]zong=new int[person];
		for(int i=0;i<person;i++){
			for(int j=0;j<jobnumber;j++){
				System.out.println("������"+name[i]+"��"+jobname[j]+"�ɼ�");
				biaoge[i][j]=in.nextInt();//���շ���
				s+=biaoge [i][j];//�ۼ����ܷ�
				still+=biaoge[i][j]+"\t";

			}

			zong[i]=s;	
			avg[i]=s/person;//ƽ����
			str[i]=name[i]+"\t"+still+avg[i]+"\t"+zong[i];//����һ��Ū��һ���ַ������Է�����Ƚ�
		}	
		for (int i=0;i<zong.length-1;i++){
			for(int j=0;j<zong.length-1;j++){
				if(zong[j]<zong[j+1]){
					int t=zong[j]; String t2=str[j];
					zong[j]=zong[j+1];str[j]=str[j+1];
					zong[j+1]=t;str[j+1]=str[j];//����
				}


			}

		}
		System.out.print("ѧ��");	
		for(int i=0;i<jobnumber;i++){
			System.out.print("\t"+jobname[i])	;//���  ѧ��  ��Ŀ  ��Ŀ ��Ŀ  ƽ���� �ܷ� ���εİ���
		}
		System.out.print("\tƽ����\t�ܷ�\t����");
		System.out.print("\n");
		for(int i=0;i<person;i++){
			System.out.println(str[i]+"\t"+"��"+(i+1)+"��");//�����ϵ��ַ������鰴˳�����
		}


	}
}


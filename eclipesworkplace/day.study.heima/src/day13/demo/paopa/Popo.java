package day13.demo.paopa;

public class Popo {
	public static void main(String[]args){
		int [] arr={30,58,39,45,69};
		int t;
		for(int i=0;i<arr.length-1;i++){//总的比较次数
			for(int j=0;j<arr.length-1-i;j++){//当次的内部比较次数
				if(arr[j]>arr[j+1]){
					t=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=t;
				}
				
			}
		}
		for(int i=0;i<5;i++){
			System.out.println(arr[i]);
		}
	}

}

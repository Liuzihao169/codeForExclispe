package domepack;
public class paoapo {
	public static void main(String []ars){
	 int arr []={8,9,85,7,6};
	 for(int i=0;i<4;i++){
		 for(int j=0;j<4-i;j++){ 
		 if(arr[j]<arr[j+1]){
			 int b;
			 b=arr[j];
			arr[j]=arr[j+1];
			arr[j+1]=b;
		 }
		 }
		 
	 }
	 
	for(int i=0;i<5;i++){
		System.out.println(arr[i]);
	}
}
}
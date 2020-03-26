package domepack;

public class text2 {
	public static void main(String []args){
		boolean a=false;
		for(int i=0;;i++){boolean f=true;
			for(int j=1;j<=i;j++){
				if(i%j==0){a=true;	
				}
				if(a){
					String str="i";
					int low=0;
					int c=str.length()-1;
				
					while(low<c){
						if(str.charAt(low)!=str.charAt(c)){
							f=false;
							break;
						}
						low++;
						c--;	
					}
					}
					
			
					}
			if(f){
				System.out.println(i);
			}
					
				}
				
			}
			
		
	}



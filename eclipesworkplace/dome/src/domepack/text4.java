package domepack;


	import java.util.*;
	public class text4 {
	      public static void main(String []args){
	    	  int max=0;
	    	  int temp=0;
	    	  int []arr={25,5,1,6,5,9,4,2};
	    	  for(int i=0;i<arr.length;i++){
	    		  max=i;
	    	  for(int j=i+1;j<arr.length;j++){
	    		  if(arr[max]<arr[j]){
	    			  max=j;}
	    		  }
	    	  if(i!=max){
	    			  temp=arr[i];
	    			  arr[i]=arr[max];
	    			  arr[max]=temp;
	    	  }	  
	    	  
	    	  }
	    	  for(int i=0;i<arr.length;i++){
	    		  System.out.println(arr[i]);
	    		  }
	    	  }
	      }




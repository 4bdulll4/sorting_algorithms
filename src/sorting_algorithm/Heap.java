package sorting_algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.io.*;

public class Heap {
	
	 private static int[] a;
	    private static int n;
	    private static int left;
	    private static int right;
	    private static int largest;
	    static int  steps = 0;
	    public static long totTime;
	    public static long time1, time2;
	    public static double second;
	   
	   
	    public static void sort(int []a0){
	    	a=a0;
	         time1 = System.currentTimeMillis();		
	    	buildheap(a);
	    	for(int i=n;i>0;i--){
	                steps++;
	    		exchange(0, i);
	    		n=n-1;
	    		maxheap(a, 0);	               
	    		System.out.println(a[i]);

	    	
	                time2 = System.currentTimeMillis();
	                totTime = time2 - time1; // Calculaing total time       
	                second = (double)(time2-time1)/1000;
	    }
			System.out.println("This Algorithm took " + totTime + " MilliSeconds and " + second +" seconds to sort the array.");
			System.out.println("No. of Steps: " + steps);
	                
	    	
	    }
	  
	    // Build-Heap method
	    public static void buildheap(int []a){
	    	n = a.length-1;
	    	for(int i=n/2;i>=0;i--){
	    		maxheap(a,i);
	    	}
	    }
	    
	    // Max-Heap methid
	    public static void maxheap(int[] a, int i){
	    	left = 2 * i;
	    	right = 2 * i + 1;
	    	if(left <= n && a[left] > a[i]){
	    		largest = left;
	    	}
	    	else{
	    		largest=i;
	    	}
	    	
	    	if(right <= n && a[right] > a[largest]){
	    		largest=right;
	    	}
	    	if(largest!=i){
	    		exchange(i,largest);
	    		maxheap(a, largest);
	    	}
	    }
	    
	    // Exchange method
	    public static void exchange(int i, int j){
	    	int t=a[i];
	    	a[i]=a[j];
	    	a[j]=t; 
	    }
}
	    	
	/* Source: http://www.code2learn.com/2011/09/heapsort-array-based-implementation-in.html */
	    

	
	   

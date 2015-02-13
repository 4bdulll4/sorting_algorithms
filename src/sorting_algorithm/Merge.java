package sorting_algorithms;

import java.util.LinkedList;
import java.util.Queue;


public class Merge 
{
	public static int steps=0;
	public static long totTime;
	public static void mergesort(int arr[], int low, int high)
	{
		steps++;
		int middle;
		if(low<high)
		{
			middle = (low+high)/2;
			mergesort(arr,low,middle);
			mergesort(arr,middle+1,high);
			merge(arr,low,middle,high);
		}
	}
	public static void merge(int arr[], int low, int middle, int high)
	{
		Queue<Integer>half1 = new LinkedList<Integer>();
		Queue<Integer>half2 = new LinkedList<Integer>();
		
		for(int j = low; j<=middle;j++)
			{				
				half1.add(arr[j]);
			}
		for(int j= middle+1 ; j<=high ; j++)
			{
				half2.add(arr[j]);
			}
		int i = low;
		while(!(half1.isEmpty() || half2.isEmpty()))
		{
			if(half1.peek() <= half2.peek())
			{
				arr[i++] = half1.poll();
				
			}
			else {arr[i++] = half2.poll();}
		}
		
		while(!half1.isEmpty())
		{
			arr[i++] = half1.poll();
		}
		while(!half2.isEmpty())
		{
			arr[i++] = half2.poll();
		}
	}
	public void sort(int arr[])
	{
		long time1 = System.currentTimeMillis();
		mergesort(arr,0,arr.length-1);
		long time2 = System.currentTimeMillis();
		
		for(int a=0;a<arr.length;a++)
			System.out.println(arr[a]);
		totTime = time2 - time1 ;
		double second = (double)(time2-time1)/1000;
	System.out.println("This Algorithm took " + totTime + " MilliSeconds and " + second +" seconds to sort the array.");
	System.out.println("No. of Steps: " + steps);

	}
	
		
	
}	

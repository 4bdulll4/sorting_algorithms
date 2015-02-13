package sorting_algorithms;

public class Quick
{
	public static int steps = 0;
	public static long totTime;
	
	public static void quicksort(int arr[], int low, int high)
	{
		steps++;
		int index;
		
		if(low<high)
		{
			index = partition(arr,low,high);
			quicksort(arr,low,index-1);
			quicksort(arr,index+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high)
	{
		int i;
		int temp;
		int pivot;
		int firsthigh;
		
		
		pivot = high;
		firsthigh = low;
		
		for(i = low;i<high;i++)
		{
			if(arr[i]<arr[pivot])
			{
				temp = arr[i];
				arr[i] = arr[firsthigh];
				arr[firsthigh] = temp;
				firsthigh++;
			}			
		}
		int temp2 = arr[pivot];
		arr[pivot] = arr[firsthigh];
		arr[firsthigh] = temp2;
		
		return firsthigh;
	}
	public void sort (int arr[])
	{
		long time1 = System.currentTimeMillis();		
		quicksort(arr,0,arr.length-1);
		long time2 = System.currentTimeMillis();
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		totTime = time2 - time1 ;
		double second = (double)(time2 - time1)/1000;
		System.out.println("This Algorithm took " + totTime + " MilliSeconds and " + second +" seconds to sort the array.");
		System.out.println("No. of Steps: " + steps);

	}
}

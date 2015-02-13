package sorting_algorithms;

public class Insertion {
	
	public static long totTime ;
	
	public void sort (int arr[], int size)
	{
		long time1 = System.currentTimeMillis();
		int steps=0;		
		int pos;
		int temp;
		
		for(int i=1;i<size;i++)				
		{
		steps++;	
		pos = i;
			
			while (pos>0 && arr[pos]<arr[pos-1] ) 
			{
			steps++;
			temp = arr[pos];
			arr[pos] = arr[pos-1]; 
			arr[pos-1] = temp; 
				
			pos--;			
			}
		}
		long time2 = System.currentTimeMillis();
		
		for(int i=0;i<size;i++)
			System.out.println(arr[i]);
		totTime = time2 - time1 ; 
		double second = (double)(time2-time1)/1000;
		System.out.println("This Algorithm took " + totTime + " MilliSeconds and " + second +" seconds to sort the array.");
		System.out.println("No. of Steps: " + steps);

	}
	
}

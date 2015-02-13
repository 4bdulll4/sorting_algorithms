package sorting_algorithms;

public class Bubble {
	
	public static long totTime;
	public void sort (int arr[], int size)
	{		
		long time1 = System.currentTimeMillis();
		
		int steps=0;
		int N = size;
		int E = N-1;
		int temp;
		boolean flag = true;
	
		while(flag)
		{
			steps++;
			flag=false;
		
			for(int a=0 ; a<E ; a++)
			{
				steps++;
				if(arr[a]>arr[a+1])
				{					
					temp=arr[a];
					arr[a]=arr[a+1];
					arr[a+1]=temp;
					flag=true;
				}	
			}
			E--;	
		} 
		long time2 = System.currentTimeMillis();
	
			for(int i=0;i<arr.length;i++)
				System.out.println(arr[i]);
			totTime = time2 - time1;
			double second = (double)(time2-time1)/1000;
			System.out.println("This Algorithm took " + totTime + " MilliSeconds and " + second +" seconds to sort the array.");
			System.out.println("No. of Steps: " + steps);

}
}

package sorting_algorithms;

public class Shell {

	public static long totTime;
	public void sort (int arr[],int size)
	{
		long time1 = System.currentTimeMillis();
		int N=size;
		int G,M,L;
		boolean flag;
		int steps=0;		
		G = (int)N/2;
		
		while(G>0)
		{
			steps++;
			M = N-G;
			
			for(int i=0;i<M ; i++)
			{
				steps++;
				if(arr[i]>arr[i+G])
				{
					L=i;
					flag=true;
					
					while(flag)
					{
						steps++;
						
						int temp;
						temp = arr[L];
						arr[L] = arr[L+G];
						arr[L+G] = temp;
						L=L-G;
						if(L>=1)
						{
							if(arr[L]<=arr[L+G])
							{
								flag=false;
							}
							else continue;						
						}
						else flag=false;
					}	
				}
			}
			G = (int)G/2;
		}	
		long time2=System.currentTimeMillis();
		
		for(int i=0;i<size;i++)
			System.out.println(arr[i]);
		totTime = time2 - time1;
		double second = (double)(time2-time1)/1000;
		System.out.println("This Algorithm took " + totTime + " MilliSeconds and " + second +" seconds to sort the array.");
		System.out.println("No. of Steps: " + steps);

	}
}

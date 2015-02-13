/* Abdulla Dlshad - 1100242 */

package sorting_algorithms;

import java.util.*;
import java.io.*;

public class sortingAlgorithms {
	
	private static Scanner input = new Scanner(System.in);
	private static int N;

	
	public static void main (String[]args)
	{ 
		Selection selection_sort = new Selection();
		Bubble bubble_sort = new Bubble();
		Insertion insertion_sort = new Insertion();
		Shell shell_sort = new Shell();
		Merge merge_sort = new Merge();
		Quick quick_sort = new Quick();
		Heap heap_sort = new Heap();
		
		String fileName;
		int arr[];
		int choice;			
		
		
		
	/*------------------------------------------------------------------------------------------------------------*/
				
		do {
			System.out.println("Welcome to Sorting Algorithms Program\n");
			System.out.println("Please enter your choice: \n");
			System.out.println("\t<1> Selection Sort\n\t<2> Bubble Sort\n\t<3> Insertion Sort\n\t<4> Shell Sort");
			System.out.println("\t<5> Mrege Sort\n\t<6> Quick Sort\n\t<7> Heap Sort\n\t<8> Sort All & Compare\n\t<9> Exit the Program.");
			
			choice = input.nextInt();
		switch (choice)
		{
		case 1:
			fileName = setSize();
			arr = new int[N];
			read(arr,fileName);
			selection_sort.sort(arr,N);
			break;
		case 2:
			fileName = setSize();
			arr = new int[N];
			read(arr,fileName);
			bubble_sort.sort(arr, N);
			break;
		case 3:
			fileName = setSize();
			arr = new int[N];
			read(arr,fileName);
			insertion_sort.sort(arr, N);
			break;
		case 4:
			fileName = setSize();
			arr = new int[N];
			read(arr,fileName);
			shell_sort.sort(arr, N);
			break;
		case 5:
			fileName = setSize();
			arr = new int[N];
			read(arr,fileName);
			merge_sort.sort(arr);
			break;			
		case 6:
			fileName = setSize();
			arr = new int[N];
			read(arr,fileName);
			quick_sort.sort(arr);
			break;
		case 7:
			fileName=setSize();
			arr = new int[N];
			//String arrr[] = {"12","45","1","67","3","123","11"};
			read(arr,fileName);
			heap_sort.sort(arr);
			break;
		case 8: 
			fileName = setSize();
			arr = new int[N];
			
			read(arr,fileName);
			selection_sort.sort(arr,N);
			
			read(arr,fileName);
			bubble_sort.sort(arr, N);
			
			read(arr,fileName);
			insertion_sort.sort(arr, N);
			
			read(arr,fileName);
			shell_sort.sort(arr, N);
			
			read(arr,fileName);
			merge_sort.sort(arr);
			
			read(arr,fileName);
			quick_sort.sort(arr);
			System.out.println("\n*----------------------------------------------------------------------*");
			System.out.println("\nThe Overal taken time for all Sorting algotithms are as follows:\n\n"
					+ "- Selection sort: " + Selection.totTime + " Millis\n"
					+"- Bubble Sort: " + Bubble.totTime + " Millis\n"
					+ "- Insertion Sort: " + Insertion.totTime + " Millis\n"
					+ "- Shell Sort: " + Shell.totTime + " Millis\n"
					+ "- Merge Sort: " + Merge.totTime + " Millis\n"
					+ "- Quick Sort: " + Quick.totTime + " Millis\n"
					+ "- Heap Sort: " + Heap.totTime + " Millis");
			
			System.out.println("The best Algorithm for sorting " + N + " items is: " + compare());
			break;
		case 9:
			System.out.print("Googbye...");
			System.exit(0);						
		default:
			System.out.println("Incorrect choice entered");
			break;	
		}
		
		}while(choice!=9);
		choice = input.nextInt();

	}
	

	
	private static  void read (int arr[], String fileName)		// reads the generated files and copy them to array.
	{		
			
			String line = null;
			Vector <String> v = new Vector <String> (); 		// firstly, put them in an vector
			try {
				
				FileReader filereader = new FileReader(fileName);		// filereader object to read
				BufferedReader buffer = new BufferedReader(filereader);	
				
			while((line = buffer.readLine()) !=null)					// read them line by line
					v.add(line);										// add each line to the end of vector
			buffer.close();												// close file
			} 
			catch (FileNotFoundException e) {							// error handling if the file not exist 
				System.out.println(e.getMessage());
			}
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			for(int a = 0 ; a<arr.length ; a++)
			{
				arr[a] = Integer.parseInt(v.elementAt(a));			// copy the contents of the vector to the array and cast them to int.
				
			}

	}
	/*---------------------------------------------- setSize ------------------------------------------------------------*/
	
	private static String setSize()
	{
		System.out.println("Please enter the data type:\n ");
		System.out.println("\t<1>  Random 500\t\t\t<2>  Reversed 500\n\t<3>  Random 1000\t\t<4>  Reversed 1000\n\t"
						   + "<5>  Random 10,000\t\t<6>  Reversed 10,000\n\t<7>  Random 100,000\t\t<8>  Reversed 100,000\n\t"
						   + "<9>  Random 1,000,000\t\t<10> Reversed 1,000,000\n\t");
		
										/* ----------------- Heading -------------------*/
		int choice;
		String dir = null;
		choice = input.nextInt();
		switch (choice)
		{
			case 1:
				dir="C:\\numbers\\rand_500.txt";
				N=500;
				break;
			case 2: 
				dir="C:\\numbers\\rvs_500.txt";
				N=500;
				break;
			case 3:
				dir="C:\\numbers\\rand_1000.txt";
				N=1000;
				break;
			case 4: 
				dir="C:\\numbers\\rvs_1000.txt";
				N=1000;
				break;
			case 5:
				dir="C:\\numbers\\rand_10000.txt";
				N=10000;
				break;
			case 6: 
				dir="C:\\numbers\\rvs_10000.txt";
				N=10000;
				break;
			case 7:
				dir="C:\\numbers\\rand_100000.txt";
				N=100000;
				break;
			case 8:
				dir="C:\\numbers\\rvs_100000.txt";
				N=100000;
			case 9: 
				dir="C:\\numbers\\rand_1000000.txt";
				N=1000000;
				break;
			case 10: 
				dir="C:\\numbers\\rvs_1000000.txt";
				N=1000000;
				break;
			
			default: 
				System.out.println("Incorrect choice entered.");
		}		
		return dir;
	}
	
	public static long compare ()
	{
		long min ;
		
		min = Selection.totTime;
		
		if(Bubble.totTime<min)
			min = Bubble.totTime;
		else if (Insertion.totTime<min)
			min = Insertion.totTime;
		else if (Shell.totTime<min)
			min = Shell.totTime;
		else if (Merge.totTime<min)
			min = Merge.totTime;
		else if(Quick.totTime<min)
			min = Quick.totTime;
		else if (Heap.totTime<min)
			min = Heap.totTime;
		return min ;
	}
	
}




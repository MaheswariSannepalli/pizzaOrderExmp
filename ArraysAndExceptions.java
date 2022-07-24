//A librarian wants to arrange books in the  order of their id's
package javaPractice4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class GetUserInput{
	
	    Scanner scan = new Scanner(System.in) ;
		public int getInput(int read_bookids ,int num_of_books)
		 {
			 int input = 0 ; 
			 try
		        {
		        	System.out.println("enter book id : ");
		        	input =  scan.nextInt() ;    
		        }
			 /* he can't handle them differently if he use multiple exceptions in a same block
			 catch( InputMismatchException | NullPointerException e)
			 {
				 System.out.println(e);
			 } */
			 catch(InputMismatchException e)
			 {
				 System.out.println("Book Id can only be integers");
			 }
			 catch( NullPointerException e2)
			 {
				 System.out.println("Book Id cannot be null");
			 }
			 finally
			 {
				 if(num_of_books == read_bookids+1 )
				  { scan.close() ; }
				 return input ;	
			 }
		 }
}
class Sorting{
	public static void InBuiltSort(int[] array)
	{
		 long startTime = System.nanoTime();
		Arrays.sort(array);
		long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " time taken to sort using inbuilt sort method - Dual-Pivot Quicksort for array  : "+elapsedTime); 
	}
	 public static void selectionSort(int[] array)
	 {  
		 long startTime = System.nanoTime();
	        for (int i = 0; i < array.length - 1; i++)  
	        {  
	            int index = i;  
	            for (int j = i + 1; j < array.length; j++)
	            {  
	                if (array[j] < array[index]){  
	                    index = j;
	                }  
	            }  
	            int smallerNumber = array[index];   
	            array[index] = array[i];  
	            array[i] = smallerNumber;  
	        }
	        long elapsedTime = System.nanoTime() - startTime;
			 System.out.println( " time taken to sort using Selectionsort for array  : "+elapsedTime); 
	   }  
}
class Searching{
	public static void InBuiltSearch(int[] array,int book_id)
	{
		 long startTime = System.nanoTime();
		Arrays.binarySearch(array,book_id);
		long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " time taken to search using inbuilt searching method - binarySearch for array  : "+elapsedTime); 
	}
	public static void linearSearch(int[] array,int book_id)
	{
		long startTime = System.nanoTime();
		 for(int i=0;i<array.length ; i++ )
		 {
			 if(array[i] == book_id)
			 {
				 break ;
			 }
		 }
		long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " time taken to search using linear searching method   : "+elapsedTime); 
	}
}
public class ArraysAndExceptions {
	 public static void main(String[] args)
	 {
		 //if he  knows the number of books it's always preferable  to go for arrays , as it consumes less space 
		 //Array creation
		 long startTime = System.nanoTime();
		 Integer[]  a  = new Integer[5];
 		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " time taken to create array  : "+elapsedTime); 
		 
		 //Array list creation
	    long startTime2 = System.nanoTime();
		ArrayList<Integer> a2  = new ArrayList<Integer>(5);
	    long elapsedTime2 = System.nanoTime() - startTime2;
	    System.out.println( " time taken to create the same array list : "+elapsedTime2); 
	    
	    //he wants to sort the array , so he must use primitive data types otherwise it takes  a lot time to unbox them for doing operations
	    int[]  books  = new int[5];
	    int i = 0 ; 
	    while( i < books.length )
	    {
	    	GetUserInput obj = new GetUserInput();
	        books[i] = obj.getInput(i , books.length) ;
	        if(books[i] > 0 )
	        {
	        	i++ ;
	        }
	    }
	    Sorting.InBuiltSort(books);
	    Sorting.selectionSort(books);
	    Searching.InBuiltSearch(books,books[4]);
	    Searching.linearSearch(books,books[4]);
	 }
}

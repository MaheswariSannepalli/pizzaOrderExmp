package javaPractice4;
//checking different type of lists performance for doing different tasks
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

//if you want to add elements quick
class Arraylist{
	ArrayList<String> students=new ArrayList<String>();   
	void adding()
	{
	    long startTime = System.nanoTime();
		students.add("maheswari");    
		students.add("sree");    
		students.add("chandu");    
		students.add("sai");    
		students.add("shanu");    
		students.add("thanu");    
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " arraylist  : "+elapsedTime ); 
	}
	void traversing()
	{
		 Iterator itr=students.iterator();
		 long startTime = System.nanoTime();
		  while(itr.hasNext())
		  {
		   itr.next();
		  }
		  long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " arraylist  : "+elapsedTime); 
	}
	void addingIndexInBetween()
	{
		 long startTime = System.nanoTime();
		students.add(5,"mahi");
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " arraylist  : "+elapsedTime); 
	}
	void removingelement()
	{
		 long startTime = System.nanoTime();
		 students.remove("sai");
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " arraylist  : "+elapsedTime); 
	}
	void sorting()
	{
		 long startTime = System.nanoTime();
		 Collections.sort(students);
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " arraylist  : "+elapsedTime); 
	}
	void searching()
	{
		long startTime = System.nanoTime();
		students.contains("mahi");
	    long elapsedTime = System.nanoTime() - startTime;
	    System.out.println( " arraylist  : "+elapsedTime); 
	}
}
//if manipulating should be done fast
class Linkedlist{
	LinkedList<String> students=new LinkedList<String>();   
	void adding()
	{
	    long startTime = System.nanoTime();
		students.add("maheswari");    
		students.add("sree");    
		students.add("chandu");    
		students.add("sai");        
		students.add("shanu");    
		students.add("thanu");    
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " Linkedlist  : "+elapsedTime ); 
	}
	void traversing()
	{
		 Iterator itr=students.iterator();
		 long startTime = System.nanoTime();
		  while(itr.hasNext())
		  {
		   itr.next();
		  }
		  long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( "Linkedlist  : "+elapsedTime); 
	}
	void addingIndexInBetween()
	{
		 long startTime = System.nanoTime();
		students.add(5,"mahi");
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " Linkedlist  : "+elapsedTime); 
	}
	void removingelement()
	{
		 long startTime = System.nanoTime();
		 students.remove("sai");
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " Linkedlist  : "+elapsedTime); 
	}
	void sorting()
	{
		 long startTime = System.nanoTime();
		 Collections.sort(students);
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " Linkedlist  : "+elapsedTime); 
	}
	void searching()
	{
		long startTime = System.nanoTime();
		students.contains("mahi");
	    long elapsedTime = System.nanoTime() - startTime;
	    System.out.println( "Linkedlist  : "+elapsedTime); 
	}
}
//if you want it to be synchronized
class vectorClass{
	Vector<String> students=new Vector<String>();   
	void adding()
	{
	    long startTime = System.nanoTime();
		students.add("maheswari");    
		students.add("sree");    
		students.add("chandu");    
		students.add("sai");        
		students.add("shanu");    
		students.add("thanu");    
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " Vector  : "+elapsedTime ); 
	}
	void traversing()
	{
		 Iterator itr=students.iterator();
		 long startTime = System.nanoTime();
		  while(itr.hasNext())
		  {
		   itr.next();
		  }
		  long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( "Vector  : "+elapsedTime); 
	}
	void addingIndexInBetween()
	{
		 long startTime = System.nanoTime();
		students.add(5,"mahi");
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " Vector  : "+elapsedTime); 
	}
	void removingelement()
	{
		 long startTime = System.nanoTime();
		 students.remove("sai");
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " Vector  : "+elapsedTime); 
	}
	void sorting()
	{
		 long startTime = System.nanoTime();
		 Collections.sort(students);
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " Vector  : "+elapsedTime); 
	}
	void searching()
	{
		long startTime = System.nanoTime();
		students.contains("mahi");
	    long elapsedTime = System.nanoTime() - startTime;
	    System.out.println( "Vector  : "+elapsedTime); 
	}
}
public class Lists {
      public static void main(String[] args)
      {
	      Arraylist obj1 = new Arraylist();
	      Linkedlist obj2 = new Linkedlist();
	      vectorClass obj3 = new vectorClass();
	      System.out.println("adding");
	      obj1.adding();
	      obj2.adding();
	      obj3.adding();
	      System.out.println("traversing");
	      obj1.traversing();
	      obj2.traversing();
	      obj3.traversing();
	      System.out.println("inserting in between");
	      obj1.addingIndexInBetween();
	      obj2.addingIndexInBetween();
	      obj3.addingIndexInBetween();
	      System.out.println("removing elements in between");
	      obj1.removingelement();
	      obj2.removingelement();
	      obj3.removingelement();
	      System.out.println("sorting");
	      obj1.sorting();
	      obj2.sorting();
	      obj3.sorting();
	      System.out.println("searching");
	      obj1.searching();
	      obj2.searching();
	      obj3.searching();
	      int[] a = new int[5];
	      Arrays.sort(a);
	   }
}

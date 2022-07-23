package javaPractice4;
//checking different type of sets performance for doing different tasks
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

//if you want to search elements more and doesn't care about insertion order
class Hashset{
	HashSet<String> products=new HashSet<String>();   
	void adding()
	{
	    long startTime = System.nanoTime();
	    products.add("milk");    
	    products.add("butter");    
	    products.add("kitkat");    
	    products.add("icecream");    
	    products.add("orange");    
	    products.add("perk");    
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " HashSet  : "+elapsedTime ); 
	}
	void traversing()
	{
		 Iterator itr=products.iterator();
		 long startTime = System.nanoTime();
		  while(itr.hasNext())
		  {
		   itr.next();
		  }
		  long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " HashSet  : "+elapsedTime); 
	}
	void sorting()
	{
		 long startTime = System.nanoTime();
		 ArrayList<String> sortedStudents = new ArrayList<String>(products);
          Collections.sort(sortedStudents);
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " Hashset  : "+elapsedTime); 
	}
	void searching()
	{
		long startTime = System.nanoTime();
		products.contains("mahi");
	    long elapsedTime = System.nanoTime() - startTime;
	    System.out.println( " Hashset : "+elapsedTime); 
	}
}
//if you want insertion order to be maintained and no duplicates
class Linkedhashset{
	LinkedHashSet<String> products=new LinkedHashSet<String>();   
	void adding()
	{
	    long startTime = System.nanoTime();
	    products.add("milk");    
	    products.add("butter");    
	    products.add("kitkat");    
	    products.add("icecream");    
	    products.add("orange");    
	    products.add("perk");    
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " Linkedhashset  : "+elapsedTime ); 
	}
	void traversing()
	{
		 Iterator itr=products.iterator();
		 long startTime = System.nanoTime();
		  while(itr.hasNext())
		  {
		   itr.next();
		  }
		  long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " Linkedhashsett  : "+elapsedTime); 
	}
	void sorting()
	{
		 long startTime = System.nanoTime();
		 ArrayList<String> sortedStudents = new ArrayList<String>(products);
          Collections.sort(sortedStudents);
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " Linkedhashset  : "+elapsedTime); 
	}
	void searching()
	{
		long startTime = System.nanoTime();
		products.contains("mahi");
	    long elapsedTime = System.nanoTime() - startTime;
	    System.out.println( "Linkedhashset : "+elapsedTime); 
	}
}
//if you want elements to be in sorted order always
class treeset{
	TreeSet<String> products=new TreeSet<String>();   
	void adding()
	{
	    long startTime = System.nanoTime();
	    products.add("milk");    
	    products.add("butter");    
	    products.add("kitkat");    
	    products.add("icecream");    
	    products.add("orange");    
	    products.add("perk");    
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " treeset  : "+elapsedTime ); 
	}
	void traversing()
	{
		 Iterator itr=products.iterator();
		 long startTime = System.nanoTime();
		  while(itr.hasNext())
		  {
		   itr.next();
		  }
		  long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " treeset  : "+elapsedTime); 
	}
	void sorting()
	{
		 long startTime = System.nanoTime();
		 long elapsedTime = System.nanoTime() - startTime;
		 System.out.println( " treeset  : "+elapsedTime); 
	}
	void searching()
	{
		long startTime = System.nanoTime();
		products.contains("mahi");
	    long elapsedTime = System.nanoTime() - startTime;
	    System.out.println( " treeset : "+elapsedTime); 
	}
}
public class Sets {

    public static void main(String[] args)
    {
          Hashset obj4 = new Hashset();
          Linkedhashset obj2 = new Linkedhashset();
          treeset obj1 = new treeset();
          System.out.println("adding");
          obj4.adding();
          obj2.adding();
          obj1.adding();
          System.out.println("traversing");
          obj4.traversing();
          obj2.traversing();
          obj1.traversing();
	      System.out.println("sorting");
	      obj4.sorting();
	      obj2.sorting();
	      obj1.sorting();
	      System.out.println("searching");
	      obj4.searching();
	      obj2.searching();
	      obj1.searching();
    }
}

package javaCombinedExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//class function - setting user details along with their addresses and cart details
class UserDetails{
	public Integer u_id;
	public String name;
	public Integer age;
	public Integer phn_num;
	private static int id = 0;
	public UserDetails(String name,Integer age,Integer phn_num)
	{
		id ++;
		this.u_id =  id  ;
		this.name = name ;
		this.age = age ;
		this.phn_num = phn_num ;
	}
	//a single User can have multiple addresses using this class , if we create outer class or another method inside this class user can't have multiple addresses 
	//here userAddress cannot exist without User (it's part of user details), so a strong association , composition exists between them
	public class UserAddress{
		public Integer a_id;
		public String city;
		public String state ; 
		public Integer pin_code;
		public UserAddress(String city , String state , Integer pin_code)
		{
			id ++;
			this.a_id = id ;
			this.city= city;
			this.state = state ;
			this.pin_code = pin_code ;
		}
	}
	//cart cannot exist without a user object
	public class Cart{
		public String item;
		public String size;
		public Cart(String item,String size)
		{
			this.item = item ;
			this.size = size ;
		}
	}
}
//enum class has fixed constants - it provides type safety as it has it's own namespace 
enum size{
	SMALL(1),MEDIUM(2),LARGE(3);
	 private final Integer p_size;   
	private size(Integer p_size) 
	 {   
	      this.p_size = p_size;
	 } 
	public Integer getSize() 
	  {            
	      return p_size;
	  }
}
//this class is used for getting products details - for getting product details from database we can simply insert commands in this class without modifying anything
class pizzas{
	private static Map<String,Integer> pizzaMenu ;   
	static
	{
		//hash map must be used , as it is fast for searching
		pizzaMenu = new TreeMap<String,Integer>();  
       pizzaMenu.put("margherita",99);  
       pizzaMenu.put("mexican green wave",239);    
       pizzaMenu.put("golden corn",79);   
       pizzaMenu.put("quick tomato",120 );   
	}
	//unmodifiable map
   static Map<String,Integer> pizzaMenuUnModified =  Collections.unmodifiableMap(pizzaMenu);

}
//for creating custom exceptions
class WrongSizeException extends Exception{
	WrongSizeException(String cause)
	{
		super(cause);
	}
}
//for displaying pizzas
class showPizzas{
	public static void display()
	   {
		   //displaying hash map using iterator interface after converting it into set
		   Iterator<Map.Entry<String, Integer>> itr = pizzas.pizzaMenuUnModified.entrySet().iterator();
		   System.out.println("Displaying pizza details");
		   while(itr.hasNext())
	       {
	            Map.Entry<String, Integer> entry = itr.next();
	            System.out.println("Pizza : " + entry.getKey() +  " , Price :  " + entry.getValue());
	       }
	   }
	//sorting hashmap based on values
	public static void sortedDisplay()
	{
		LinkedList list = new LinkedList(pizzas.pizzaMenuUnModified.entrySet());
		//sorting them using custom comparator
		Collections.sort(list, (o1, o2) -> ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue()));  
		//copying the sorted list in HashMap to preserve the iteration order  
		 Iterator<Map.Entry<String, Integer>> itr = list.iterator();
		   System.out.println("Displaying pizza details");
		   while(itr.hasNext())
	       {
			   Map.Entry<String, Integer> entry = itr.next();
	            System.out.println("Pizza : " + entry.getKey() +  " , Price :  " + entry.getValue());
	       }
	}
}
//class for checking availability of pizzas and sizes
class Availability{
	//searching for pizza using containsKey method
	static boolean searchForPizza(String pizza)
	{
		return pizzas.pizzaMenuUnModified.containsKey(pizza);
	}
	//checking whether user selected proper size or not
	static int searchForSizeAndPrize(String p_size,String p_name) throws WrongSizeException 
	{
		  try {
		         size pizzaSize = size.valueOf(p_size.toUpperCase());
		         //2 Unboxings will happen here and we should retrun int type only to reduce calculation delay in the called program
		         return pizzas.pizzaMenuUnModified.get(p_name) * pizzaSize.getSize() ;
			  }
		  catch(Exception e)
			  {
			  //converting unchecked exception into user defined exception
			  WrongSizeException exception = new WrongSizeException("couldn't order "+p_name+" pizza"); 
			  exception.initCause(  new WrongSizeException("size not found"));  
			  throw exception;
			  //if we won't re throw the exception here we can't execute finally block in the called class
			/*  System.out.println(exception.getMessage());
	   	    	System.out.println(exception.getCause().getMessage());
	   	    	return false;*/
			  }
	}
}
//class for placing order
class PlaceOrder {
	//a private inner class because no one should be able to access it directly and only if user places an order order details should be  saved
	 private class SaveOrderDetails
	{
		public Integer user_id ;
		public Integer address_id ;
		public String item ;
		public String size ;
		public Integer price ;
		SaveOrderDetails(Integer user_id ,Integer address_id ,String item , String size ,Integer price){
			this.user_id = user_id ;
			this.address_id = address_id ;
			this.item  = item ;
			this.size  = size ;
			this.price = price ;
		}
	}
	 //queue is used here because it follows fifo . and all orders should be taken in that order
	private static Queue<SaveOrderDetails> orderQueue = new LinkedList<SaveOrderDetails>();
	//for ordering
	public void orderAll(Integer user_id ,Integer address_id , ArrayList<UserDetails.Cart> cart )
	{
		Iterator<UserDetails.Cart> itr=cart.iterator();
		//these variables should also be primitive types
		int totalPrice = 0;
		int each_order_price ;
		//iterating over array list using iterator interface
 		  while(itr.hasNext())
		  {
			  UserDetails.Cart userOrder = (UserDetails.Cart) itr.next() ;
			  each_order_price = order(userOrder.item,userOrder.size) ;  
			  if(each_order_price > 0) 
			  {
		     	  totalPrice = totalPrice + each_order_price ;
		     	//  saving details
		     	 SaveOrderDetails d1 = new SaveOrderDetails(user_id ,address_id , userOrder.item,userOrder.size ,each_order_price);
		     	orderQueue.add(d1);
			  }
		  }
 		 System.out.println("user_id : "+user_id+" your total order price is : "+totalPrice);
	}
	//this method should be private . so it will be accessible only inside
	private int order(String pizza,String size)
	{
		int price = 0;
   		try {
   			//checking pizza availability
		if(!Availability.searchForPizza(pizza)) 
   			{ 
   				System.out.println("couldn't order "+pizza+ "  : Pizza not available");
   			}
   			else {
   				//getting price and checking exception
   				price = Availability.searchForSizeAndPrize(size,pizza);	
   				System.out.println("ordered " +pizza+"  price : "+price);
   			}
   		}
   		catch(Exception e)
   		{
   			System.out.println(e.getMessage());
   	    	System.out.println(e.getCause().getMessage());
   		}
   		finally {
   			//price must be returned if an error is thrown or not
   			return price;
   		}
	}	
}

public class User {

	public static void main(String[] args)
	{
		//hash map must be used , because  If user add a new address then the value will be modified but user remains same and it is faster for adding details 
		Map<UserDetails,ArrayList<UserDetails.UserAddress>> userData = new HashMap<UserDetails,ArrayList<UserDetails.UserAddress>>();
		
		//user 1 entering details
		UserDetails user1 = new UserDetails("maheswari",19,987632255);
		UserDetails.UserAddress address1 = user1.new UserAddress("west godavari","andhra",507121);
		//ArrayLists are used as they take less time for adding 
		ArrayList<UserDetails.UserAddress> user1Addresses = new ArrayList<UserDetails.UserAddress>();
		user1Addresses.add(address1);
		userData.put(user1, user1Addresses) ; 
		
		//user1 adding new address
		UserDetails.UserAddress address2 = user1.new UserAddress("west godavari","andhra",507121);
		user1Addresses.add(address2);
		userData.put(user1, user1Addresses);
		
		//user1 selecting items
		UserDetails.Cart order1 = user1.new Cart("margherita","small");
		UserDetails.Cart order2 = user1.new Cart("margherita","extra large");
		
		//adding items to cart to order
		ArrayList<UserDetails.Cart> user1Cart = new ArrayList<UserDetails.Cart>();
		user1Cart.add(order1);
		user1Cart.add(order2);
		
		//placing order
		 PlaceOrder o1  = new  PlaceOrder();
		 o1.orderAll(user1.u_id, address1.a_id, user1Cart);
		 
		 //removing elements of array list using removeAll() method
		 user1Cart.removeAll(user1Cart);
		 System.out.println(user1.name+ " cart cleared ");
		 
		 //searching for an element in hash map
		System.out.println(Availability.searchForPizza("margherita"));
		
		 //user2
		 UserDetails user2 = new UserDetails("mahi",19,987632255);
		 UserDetails.UserAddress address3 = user2.new UserAddress("west godavari","andhra",507121);
		 ArrayList<UserDetails.UserAddress> user2Addresses = new ArrayList<UserDetails.UserAddress>();
		 user2Addresses.add(address3);
		 userData.put(user2, user2Addresses) ; 
		 
		 UserDetails.Cart order3 = user2.new Cart("margherita","small");
		 UserDetails.Cart order4 = user2.new Cart("golden corn","large");
			
			ArrayList<UserDetails.Cart> user2Cart = new ArrayList<UserDetails.Cart>();
			user2Cart.add(order3);
			user2Cart.add(order4);
			
			 PlaceOrder o2  = new  PlaceOrder();
			 o2.orderAll(user2.u_id, address2.a_id, user2Cart);
			 
			 //displaying items
			 showPizzas.display();
			 //displaying items based on sorted price
			 showPizzas.sortedDisplay();
	}
}

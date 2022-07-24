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
//class is open for extension
class UserDetails{
	private Integer u_id;
	private String name;
	private Integer age;
	private Integer phn_num;
	private static int id = 0;
	public UserDetails()
	{
		id ++;
		this.u_id =  id  ;
	}
	public Integer getU_id()
	{
		return u_id ;
	}
	public void setName(String name)
	{
		this.name = name ;
	}
	public String getName()
	{
		return name ;
	}
	public void setAge(Integer age)
	{
		this.age = age ;
	}
	public Integer getAge()
	{
		return age ;
	}
	public void setPhn_num(Integer phn_num)
	{
		this.phn_num = phn_num ;
	}
	public Integer getPhn_num()
	{
		return phn_num ;
	}
	//a single User can have multiple addresses using this class , if we create outer class or another method inside this class user can't have multiple addresses 
	//here userAddress cannot exist without User (it's part of user details), so a strong association , composition exists between them
	public class UserAddress{
		private Integer a_id;
		private String city;
		private String state ; 
		private Integer pin_code;
		public UserAddress()
		{
			id ++;
			this.a_id = id ;
		}
		public Integer getA_id()
		{
			return a_id ;
		}
		public void setCity(String city)
		{
			this.city = city ;
		}
		public String getCity()
		{
			return city ;
		}
		public void setState(String state)
		{
			this.state= state ;
		}
		public String getState()
		{
			return state ;
		}
		public void setPin_code(Integer pin_code)
		{
			this.pin_code = pin_code ;
		}
		public Integer getPin_code()
		{
			return pin_code ;
		}
	}
	//cart cannot exist without a user object
	public class Cart{
		private String item;
		private String size;
		public void setItem(String item)
		{
			this.item = item ;
		}
		public String getItem()
		{
			return item ;
		}
		public void setSize(String size)
		{
			this.size= size ;
		}
		public String getSize()
		{
			return size ;
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
		private Integer user_id ;
		private Integer address_id ;
		private String item ;
		private String size ;
		private Integer price ;

		public void setUser_id(Integer user_id)
		{
			this.user_id = user_id ;
		}
		public Integer getUser_id()
		{
			return user_id ;
		}
		public void setAddress_id(Integer address_id)
		{
			this.address_id = address_id ;
		}
		public Integer getAddress_id()
		{
			return address_id ;
		}
		public void setItem(String item)
		{
			this.item = item ;
		}
		public String getItem()
		{
			return item ;
		}
		public void setSize(String size)
		{
			this.size = size ;
		}
		public String getSize()
		{
			return size ;
		}
		public void setprice(Integer price)
		{
			this.price = price ;
		}
		public Integer getprice()
		{
			return price ;
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
			  each_order_price = order(userOrder.getItem(),userOrder.getSize()) ;  
			  if(each_order_price > 0) 
			  {
		     	  totalPrice = totalPrice + each_order_price ;
		     	//  saving details
		     	 SaveOrderDetails d1 = new SaveOrderDetails();
		     	 d1.setUser_id(user_id);
		     	 d1.setAddress_id(address_id);
		     	 d1.setItem(userOrder.getItem());
		     	 d1.setSize(userOrder.getSize());
		     	 d1.setprice(each_order_price);
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
   		return price;
	}	
}

//class for storing user details
class storeUserDetails{
	//hash map must be used , because  If user add a new address then the value will be modified but user remains same and it is faster for adding details 
	static Map<UserDetails,ArrayList<UserDetails.UserAddress>> userData = new HashMap<UserDetails,ArrayList<UserDetails.UserAddress>>();
	static void saved(UserDetails user,ArrayList<UserDetails.UserAddress> address)
	{
		userData.put(user, address) ; 
	}
}
public class User {

	public static void main(String[] args)
	{
		//user 1 entering details
		UserDetails user1 = new UserDetails();
		user1.setName("maheswari");
		user1.setAge(19);
		user1.setPhn_num(987233561);
		
		UserDetails.UserAddress address1 = user1.new UserAddress();
		address1.setCity("west godavari");
		address1.setState("andhra");
		address1.setPin_code(507121);
		
		//ArrayLists are used as they take less time for adding 
		ArrayList<UserDetails.UserAddress> user1Addresses = new ArrayList<UserDetails.UserAddress>();
		user1Addresses.add(address1);
		
		storeUserDetails.saved(user1,user1Addresses);
		
		//user1 adding new address
		UserDetails.UserAddress address2 = user1.new UserAddress();
		address2.setCity("west godavari");
		address2.setState("andhra");
		address2.setPin_code(507121);
		user1Addresses.add(address2);

		storeUserDetails.saved(user1,user1Addresses);
		
		//user1 selecting items
		UserDetails.Cart order1 = user1.new Cart();
		order1.setItem("margherita");
		order1.setSize("small");
		
		UserDetails.Cart order2 = user1.new Cart();
		order2.setItem("margherita");
		order2.setSize("extra large");
		
		//adding items to cart to order
		ArrayList<UserDetails.Cart> user1Cart = new ArrayList<UserDetails.Cart>();
		user1Cart.add(order1);
		user1Cart.add(order2);
		
		//placing order
		 PlaceOrder o1  = new  PlaceOrder();
		 o1.orderAll(user1.getU_id(), address1.getA_id(), user1Cart);
		 
		 //removing elements of array list using removeAll() method
		 user1Cart.removeAll(user1Cart);
		 System.out.println(user1.getName()+ " cart cleared ");
		 
		 //searching for an element in hash map
		System.out.println(Availability.searchForPizza("margherita"));
		
		 //user2
		 UserDetails user2 = new UserDetails();
		 user1.setName("mahi");
		 user1.setAge(19);
		 user1.setPhn_num(68233561);
		 
		 UserDetails.UserAddress address3 = user2.new UserAddress();
		 address3.setCity("west godavari");
		 address3.setState("andhra");
		 address3.setPin_code(507121);
		 
		 ArrayList<UserDetails.UserAddress> user2Addresses = new ArrayList<UserDetails.UserAddress>();
		 user2Addresses.add(address3);

		 storeUserDetails.saved(user2,user2Addresses);
		 
		 UserDetails.Cart order3 = user2.new Cart();
		 order3.setItem("margherita");
		 order3.setSize("small");
		 
		 UserDetails.Cart order4 = user2.new Cart();
		 order4.setItem("golden corn");
		 order4.setSize("large");
			
			ArrayList<UserDetails.Cart> user2Cart = new ArrayList<UserDetails.Cart>();
			user2Cart.add(order3);
			user2Cart.add(order4);
			
			 PlaceOrder o2  = new  PlaceOrder();
			 o2.orderAll(user2.getU_id(), address2.getA_id(), user2Cart);
			 
			 //displaying items
			 showPizzas.display();
			 //displaying items based on sorted price
			 showPizzas.sortedDisplay();
	}
}

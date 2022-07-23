package javaPractice4;

 class PrimitiveToPrimitive{
	 public static void arrays()
	 {
		 int index =0;
		 long[]  a = new long[1000];
		 long startTime = System.nanoTime();
		 for(long i =0 ;i<1000;i++)
		 {
			 //no  unboxing or boxing
			 a[index] = i ;
			 index ++ ;
		 }
		 long elapsedTime = System.nanoTime() - startTime;
	      System.out.println( " PrimitiveToPrimitive adding elements into array  : "+elapsedTime/10000 + "milli seconds"); 
	 }
	 public static void addValues()
	 {
         int total = 0;
         long startTime = System.nanoTime();
        for (int i = 0; i< 1000000; i++) 
        {
      	 //no  unboxing or boxing
           total = total + i ;
        }
      long elapsedTime = System.nanoTime() - startTime;

      System.out.println( " PrimitiveToPrimitive finding total sum : "+elapsedTime/10000 + "milli seconds"); 
	 }
 }
 
 class ObjectToObject{
	 public static void arrays()
	 {
		 int index =0;
		 Long[]  a = new Long[1000];
		 long startTime = System.nanoTime();
		 for(Long i =0L ;i<1000;i++)
		 {
			 //no unboxing
			 a[index] = i ;
			 index ++ ;
		 }
		 long elapsedTime = System.nanoTime() - startTime;

	      System.out.println( " ObjectToObject adding elements into array : "+elapsedTime/10000 + "milli seconds"); 
	 }
	 public static void addValues()
	 {
         Long total = 0L;
         long startTime = System.nanoTime();
        for (Long i = 0L; i< 1000000; i++) 
        {
      	 // 2 unboxings and  boxing
           total = total + i ;
        }
      long elapsedTime = System.nanoTime() - startTime;

      System.out.println( "ObjectToObject finding total sum : "+elapsedTime/10000 + "milli seconds"); 
	 }
 }
 class ObjectToPrimitive{
	 public static void arrays()
	 {
		 int index =0;
		 long[]  a = new long[1000];
		 long startTime = System.nanoTime();
		 for(Long i =0L ;i<1000;i++)
		 {
			 //unboxing
			 a[index] = i ;
			 index ++ ;
		 }
		 long elapsedTime = System.nanoTime() - startTime;

	      System.out.println( "ObjectToPrimitive adding elements into array  : "+elapsedTime/10000 + "milli seconds"); 
	 }
	 public static void addValues()
	 {
        Long total = 0L;
        long startTime = System.nanoTime();
        for (long i = 0; i< 1000000; i++) 
        {
      	 // unboxing and  boxing
           total = total + i ;
        }
      long elapsedTime = System.nanoTime() - startTime;

      System.out.println( "ObjectToPrimitive finding total sum : "+elapsedTime/10000 + "milli seconds"); 
	 }
 }
 class PrimitiveToObject{
	 public static void arrays()
	 {
		 int index =0;
		 Long[]  a = new Long[1000];
		 long startTime = System.nanoTime();
		 for(long i =0 ;i<1000;i++)
		 {
			 // boxing
			 a[index] = i ;
			 index ++ ;
		 }
		 long elapsedTime = System.nanoTime() - startTime;

	      System.out.println( " PrimitiveToObject adding elements into arrays : "+elapsedTime/10000 + "milli seconds"); 
	 }
	 public static void addValues()
	 {
         long total = 0;
         long startTime = System.nanoTime();
        for (Long i = 0L; i< 1000000; i++) 
        {
      	 // unboxing 
           total = total + i ;
        }
      long elapsedTime = System.nanoTime() - startTime;

      System.out.println( "PrimitiveToObject finding total sum : "+elapsedTime/10000 + "milli seconds"); 
	 }
 }

public class TimeElapsesofboxing {

	public static void main(String[] args)
	{
		ObjectToObject.addValues();
		ObjectToPrimitive.addValues();
		PrimitiveToObject.addValues();
		PrimitiveToPrimitive.addValues();
		
		ObjectToObject.arrays();
		ObjectToPrimitive.arrays();
		PrimitiveToObject.arrays();
		PrimitiveToPrimitive.arrays();
		
	   long startTime = System.nanoTime();
       int[] a1 = new int[10000];
       long elapsedTime = System.nanoTime() - startTime;

       System.out.println( "for creating integer array  : "+elapsedTime); 
       
       long startTime2 = System.nanoTime();
       Integer[] a2 = new Integer[10000];
       long elapsedTime2 = System.nanoTime() - startTime2;

       System.out.println( "for creating object data type integer array : "+elapsedTime2); 
       
       long startTime3 = System.nanoTime();
       double[] a3 = new double[10000];
       long elapsedTime3 = System.nanoTime() - startTime3;

       System.out.println( "for creating double type array : "+elapsedTime3); 
       
       long startTime4 = System.nanoTime();
       Double[] a4 = new Double[10000];
       long elapsedTime4 = System.nanoTime() - startTime4;

       System.out.println( "for creating object data type double array : "+elapsedTime4); 
	}
}

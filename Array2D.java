package javaPractice4;

import java.util.Scanner;

public class Array2D {

	public static void main(String[] args) 
    { 
		//if we use lists here we need to create a new class
           int[][] a = new int[3][5]; 
           int i, j; 
           Scanner input=new Scanner(System.in); 
          
           for(i=0;i<3; i++) 
               { 
        	   System.out.print("Enter the marks for student  : "+(i+1) ); 
                  for(j=0; j<5;j++) 
                  a[i][j]=input.nextInt(); 
               } 
           
           for(i=0;i<3;i++) 
               {   
        	   System.out.println("sum of marks of student  :  "+(i+1) ); 
        	   int sum =0 ;
                  for(j=0; j<5; j++) 
                  {
                	  sum = sum + a[i][j] ;
                  }
                  System.out.println(sum);
               } 
      } 
}

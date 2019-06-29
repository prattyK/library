package arrays;

class A { 
   static void fun() { 
      System.out.println("A.fun()"); 
   } 
} 
  
class B extends A {  
   static void fun() {    
      System.out.println("B.fun()"); 
   } 
} 
  
public class Main { 
   public static void main(String args[]) { 
      A a = new B(); 
      a.fun();  // prints A.fun() 
   } 
}
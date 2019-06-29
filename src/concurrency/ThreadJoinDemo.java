package concurrency;
class ThreadJoinDemo extends Thread{
 static ThreadJoinDemo thread1;
 
 public void run(){
  try{
   synchronized(thread1){
    System.out.println(Thread.currentThread().getName()+" acquired a lock on thread1111111111");
    Thread.sleep(5000);
    System.out.println(Thread.currentThread().getName()+" completed");
   }
  }
  catch (InterruptedException e){ }
 }
 
 public static void main(String[] ar) throws Exception{
  thread1 = new ThreadJoinDemo();
  thread1.setName("thread1");
  thread1.start();
 
  ThreadJoinDemo thread2 = new ThreadJoinDemo();
  thread2.setName("thread2");
  thread2.start();
 
  
  synchronized(thread1){
   System.out.println(Thread.currentThread().getName()+" acquired a lock on thread1");
   Thread.sleep(1000);
//   thread1.join();
//   thread2.join();
   System.out.println(Thread.currentThread().getName()+" completed");
  }
 }
}
package Java_concepts.Concurrency;
//https://www.javamadesoeasy.com/2015/03/semaphore-in-java.html
import java.util.concurrent.Semaphore;
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class SemaphoreExample {
 
    static int SharedValue=0;
    
    public static void main(String[] args) {
           Semaphore semaphore=new Semaphore(1); 
           System.out.println("Semaphore with 1 permit has been created");

           
           IncrementThread incrementThread=new IncrementThread(semaphore);
           new Thread(incrementThread,"incrementThread").start();
           
           DecrementThread decrementThread=new DecrementThread(semaphore);
           new Thread(decrementThread,"decrementThread").start();
           
    }
}
 


 
 
class IncrementThread implements Runnable{
 
    Semaphore semaphore;
    
    public IncrementThread(Semaphore s) {
           semaphore=s;      
    }
    
    public void run(){
           System.out.println(Thread.currentThread().getName()+
                        " is waiting for permit");
           try {
                  semaphore.acquire();
                  System.out.println(Thread.currentThread().getName()+
                               " has got permit");
           
                  for(int i=0;i<5;i++){
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                      " > "+SemaphoreExample.SharedValue++);
                  }
                  
           }catch (InterruptedException e) {
               e.printStackTrace();
           }

        System.out.println(Thread.currentThread().getName()+
                " has released permit");
        semaphore.release();

    }

}





class DecrementThread implements Runnable{

    Semaphore semaphore;
    public DecrementThread(Semaphore s){
        semaphore=s;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+
                " is waiting for permit");

        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+
                    " has got permit");

            for(int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+
                        " >"+SemaphoreExample.SharedValue--);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }  System.out.println(Thread.currentThread().getName()+
                " has released permit");
        semaphore.release();


    }

}

/*OUTPUT

Semaphore with 1 permit has been created
incrementThread is waiting for permit
incrementThread has got permit
decrementThread is waiting for permit
incrementThread > 0
incrementThread > 1
incrementThread > 2
incrementThread > 3
incrementThread > 4
incrementThread has released permit
decrementThread has got permit
decrementThread >5
decrementThread >4
decrementThread >3
decrementThread >2
decrementThread >1
decrementThread has released permit

*/

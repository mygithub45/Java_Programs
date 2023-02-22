package Java_concepts.Concurrency;
//https://www.javamadesoeasy.com/2015/03/executor-and-executorservice-framework.html
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
 class MyRunnable1 implements Runnable {
 
    int taskNumber;
 
    MyRunnable1(int taskNumber) {
           this.taskNumber = taskNumber;
    }
 
    @Override
    public void run() {
 
           System.out.println(Thread.currentThread().getName()
                        + " executing task no " + taskNumber);
 
           try {
                  Thread.sleep(1000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
 
    }
}
     public class ExecutorServiceExample {

    //nThreads number of threads will be created and started in executor.
    //here we will create 2 threads.
    private static int nThreads = 2;

    //nTasks number of tasks will be executed.
    //here we will execute 10 tasks.
    private static int nTasks = 10;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        System.out.println("executor created with 2 threads.");

        System.out.println("2 threads in executor will be used for executing 10 tasks. "
                + "So, at a time only 2 tasks will be executed");
        for (int i = 1; i <= nTasks; i++) {
            Runnable task = new MyRunnable1(i);
            executor.execute(task);
        }

        /*
         * Initiates shutdown of executor, previously submitted tasks are
         * executed, but no new tasks will be accepted.
         */
        executor.shutdown();

        System.out.println("executor has been shutDown.");
    }
}
 /*OUTPUT

executor created with 2 threads.
2 threads in executor will be used for executing 10 tasks. So, at a time only 2 tasks will be executed
pool-1-thread-1 executing task no 1
pool-1-thread-2 executing task no 2
executor has been shutDown.
pool-1-thread-1 executing task no 3
pool-1-thread-2 executing task no 4
pool-1-thread-1 executing task no 5
pool-1-thread-2 executing task no 6
pool-1-thread-1 executing task no 7
pool-1-thread-2 executing task no 8
pool-1-thread-2 executing task no 9
pool-1-thread-1 executing task no 10

*/

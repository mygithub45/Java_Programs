package Java_concepts.Concurrency;
//https://www.javamadesoeasy.com/2015/03/implement-thread-pool-in-java.html
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
class ThreadPool {
 
    private BlockingQueue<Runnable> taskQueue;
   
    /*
     * Once pool shutDown will be initiated, poolShutDownInitiated will become true.
     */
    private boolean poolShutDownInitiated = false;
 
    /* Constructor of ThreadPool
     * nThreads= is a number of threads that exist in ThreadPool.
     * nThreads number of threads are created and started.  *
     */
    public ThreadPool(int nThreads){
        taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);
 
        //Create and start nThreads number of threads.
        for(int i=1; i<=nThreads; i++){
           ThreadPoolsThread threadPoolsThread=new ThreadPoolsThread(taskQueue,this);
         threadPoolsThread.setName("Thread-"+i);
         System.out.println("Thread-"+i +" created in ThreadPool.");
         threadPoolsThread.start();   //start thread
        }
       
    }
    /**
     * Execute the task, task must be of Runnable type.
     */
    public synchronized void  execute(Runnable task) throws Exception{
        if(this.poolShutDownInitiated)
            throw new Exception("ThreadPool has been shutDown, no further tasks can be added");

        /*
         * Add task in sharedQueue,
         * and notify all waiting threads that task is available.
         */
        System.out.println("task has been added.");
        this.taskQueue.put(task);
    }


    public boolean isPoolShutDownInitiated() {
        return poolShutDownInitiated;
    }


    /**
     * Initiates shutdown of ThreadPool, previously submitted tasks
     * are executed, but no new tasks will be accepted.
     */
    public synchronized void shutdown(){
        this.poolShutDownInitiated = true;
        System.out.println("ThreadPool SHUTDOWN initiated.");
    }

}
/**
 * These threads are created and started from constructor of ThreadPool class.
 */
class ThreadPoolsThread extends Thread {

    private BlockingQueue<Runnable> taskQueue;
    private ThreadPool threadPool;

    public ThreadPoolsThread(BlockingQueue<Runnable> queue,
                             ThreadPool threadPool){
        taskQueue = queue;
        this.threadPool=threadPool;

    }
    public void run() {
        try {
            /*
             * ThreadPool's threads will keep on running
             * until ThreadPool is not shutDown (shutDown will interrupt thread) and
             * taskQueue contains some unExecuted tasks.
             */
            while (true) {
                System.out.println(Thread.currentThread().getName()
                        +" is READY to execute task.");
                /*ThreadPool's thread will take() task from sharedQueue
                 * only if tasks are available else
                 * waits for tasks to become available.
                 */
                Runnable runnable = taskQueue.take();
                System.out.println(Thread.currentThread().getName()
                        +" has taken task.");
                //Now, execute task with current thread.
                runnable.run();

                System.out.println(Thread.currentThread().getName()
                        +" has EXECUTED task.");

                /*
                 * 1) Check whether pool shutDown has been initiated or not,
                 * if pool shutDown has been initiated and
                 * 2) taskQueue does not contain any
                 *    unExecuted task (i.e. taskQueue's size is 0 )
                 * than  interrupt() the thread.
                 */
                if(this.threadPool.isPoolShutDownInitiated()
                        &&  this.taskQueue.size()==0){
                    this.interrupt();
                    /*
                     *  Interrupting basically sends a message to the thread
                     *  indicating it has been interrupted but it doesn't cause
                     *  a thread to stop immediately,
                     *
                     *  if sleep is called, thread immediately throws InterruptedException
                     */
                    Thread.sleep(1);
                }

            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
        }
    }
}


/**
 * Task class which implements Runnable.
 */
class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()
                    +" is executing task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};
/**
 * Test ThreadPool.
 */
 class ThreadPoolTest{
    public static void main(String[] args) throws Exception {
        ThreadPool threadPool=new ThreadPool(2); //create 2 threads in ThreadPool
        Runnable task=new Task();
        threadPool.execute(task);
        threadPool.execute(task);

        threadPool.shutdown();
    }

}

/*OUTPUT

Thread-1 created in ThreadPool.
Thread-2 created in ThreadPool.
Thread-1 is READY to execute task.
Thread-2 is READY to execute task.
task has been added.
task has been added.
Thread-1 has taken task.
Thread-2 has taken task.
ThreadPool SHUTDOWN initiated.
Thread-1 is executing task.
Thread-1 has EXECUTED task.
Thread-1 has been STOPPED.
Thread-2 is executing task.
Thread-2 has EXECUTED task.
Thread-2 has been STOPPED.

*/
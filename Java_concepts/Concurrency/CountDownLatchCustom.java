package Java_concepts.Concurrency;
//https://www.javamadesoeasy.com/2015/03/implementation-of-customown_31.html
//https://www.javamadesoeasy.com/2015/03/countdownlatch-in-java.html
class CountDownLatchCustom{
 
    private int count;
    /**
     * CountDownLatch is initialized with given count.
     * count specifies the number of events that must occur
     * before latch is released.
     */
    public CountDownLatchCustom(int count) {
           this.count=count;
    }
    /**
     * Causes the current thread to wait until  one of the following things happens-
     - latch count has down to reached 0, or
     - unless the thread is interrupted.
     */
    public synchronized void await() throws InterruptedException {
        //If count is greater than 0, thread waits.
        if(count>0)
            this.wait();
    }

    /**
     *  Reduces latch count by 1.
     *  If count reaches 0, all waiting threads are released.
     */
    public synchronized void countDown() {
        //decrement the count by 1.
        count--;

        //If count is equal to 0, notify all waiting threads.
        if(count == 0)
            this.notify();
    }

}

/**
 * Main class
 */
 class CountDownLatchCustomTest {

    public static void main(String[] args) {
        CountDownLatchCustom countDownLatchCustom=new CountDownLatchCustom(3);
        System.out.println("CountDownLatch has been created with count=3");

        new Thread(new MyRunnable(countDownLatchCustom),"Thread-1").start();

        try {
            countDownLatchCustom.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count has reached zero, "+
                Thread.currentThread().getName()+" thread has ended");

    }

}
class MyRunnable implements Runnable{

    CountDownLatchCustom countDownLatchCustom;

    MyRunnable(CountDownLatchCustom countDownLatchCustom){
        this.countDownLatchCustom=countDownLatchCustom;
    }

    public void run(){

        for(int i=2;i>=0;i--){

            countDownLatchCustom.countDown();
            System.out.println(Thread.currentThread().getName()+
                    " has reduced latch count to : "+ i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
 /*OUTPUT

CountDownLatch has been created with count=3
Thread-1 has reduced latch count to : 2
Thread-1 has reduced latch count to : 1
Thread-1 has reduced latch count to : 0
count has reached zero, main thread has ended

*/
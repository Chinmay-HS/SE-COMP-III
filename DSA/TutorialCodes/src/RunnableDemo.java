public class RunnableDemo {
    public static void main(String[] args) {
        System.out.println("Main thread is: " + Thread.currentThread().getName());
        Thread t1 = new Thread(new RunnableDemo().new RunnableImpl(), "Thread-1");
        Thread t2 = new Thread(new RunnableDemo().new RunnableImpl(), "Thread-2");
        t1.start();
        t2.start();
    }
    private class RunnableImpl implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is executing run() method!");
        }
    }
}
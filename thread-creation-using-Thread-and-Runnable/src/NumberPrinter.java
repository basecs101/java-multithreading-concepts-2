//NumberPrinter prints numbers between 1-10
class NumberPrinter {
     void printNumber() throws InterruptedException {
         synchronized (this) {
             System.out.println("Inside printNumber() method " + Thread.currentThread().getName() + " called print() method!!!"+ "" +
                     "Thread state is : "+ Thread.currentThread().getState());
             for (int i = 1; i <=3; i++) {
                 //here i is local variable for thread and
                 // hence i will be stored in thread stack
                 // thread-stack is a memory area that is local for each thread
                 Thread.sleep(1000);//Thread goes to Timed_Waiting, thread is waiting for finite amount of time
                 System.out.println(Thread.currentThread() + " i = " + i);
             }
         }
    }
}
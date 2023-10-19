
public class ThreadExampleUsingThreadClass {
    public static void main(String[] args) {
        System.out.println("main method start: "+ Thread.currentThread());
        NumberPrinter numberPrinter = new NumberPrinter();

        Thread thread1 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-1");
        thread1.setPriority(Thread.MAX_PRIORITY);
        Thread thread2 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-2");
        thread1.setPriority(Thread.NORM_PRIORITY);
        Thread thread3 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-3");
        thread1.setPriority(Thread.MIN_PRIORITY);

        try{
            thread1.start();//thread1 is calling run method
            thread2.start();//thread2 is calling run method
            thread3.start();//thread3 is calling run method

        }catch (RuntimeException e){
            System.out.println("RuntimeTime exception occurred.");
            e.printStackTrace();
        }
        System.out.println("main method end : "+ Thread.currentThread());
    }
}
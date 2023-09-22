//NumberPrinter prints numbers between 1-10
class NumberPrinter {
    synchronized void print() throws InterruptedException {
        for (int i = 1; i <=5; i++) {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread() + " i = " + i);
        }
    }
}

//NumberPrinterThread will print numbers
//There can be one or more number printer threads printing numbers in sequence or parallel.
class NumberPrinterThread extends Thread {
    NumberPrinter numberPrinter;

    NumberPrinterThread(NumberPrinter numberPrinter){
        this.numberPrinter = numberPrinter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " called run() method!!!");
        try {
            Thread.sleep(2000);
            this.numberPrinter.print();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class ThreadExampleUsingThreadClass {
    public static void main(String[] args) {
        System.out.println("main method start: "+ Thread.currentThread());
        NumberPrinter numberPrinter = new NumberPrinter();

        NumberPrinterThread thread1 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-1");
        NumberPrinterThread thread2 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-2");
        NumberPrinterThread thread3 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-3");

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
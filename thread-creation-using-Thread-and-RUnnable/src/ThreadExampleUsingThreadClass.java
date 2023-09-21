//NumberPrinter prints numbers between 1-10
class NumberPrinter {
    synchronized void print(){
        for (int i = 1; i <=10; i++) {
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
        numberPrinter.print();
    }
}
public class ThreadExampleUsingThreadClass {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        NumberPrinterThread thread1 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-1");
        NumberPrinterThread thread2 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-2");
        NumberPrinterThread thread3 = new NumberPrinterThread(numberPrinter);
        thread1.setName("Thread-3");

//
        thread1.start();//thread1 is calling run method
        thread2.start();//thread2 is calling run method
        thread3.start();//thread3 is calling run method
    }
}
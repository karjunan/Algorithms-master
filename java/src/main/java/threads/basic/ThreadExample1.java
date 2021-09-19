package threads.basic;

public class ThreadExample1 extends Thread {

    @Override
    public void run() {
        int j = 0;
        while(j < 1) {
            System.out.println(" j = " + j + " ===> " + this.getName());
            j += 1;
        }
    }
}

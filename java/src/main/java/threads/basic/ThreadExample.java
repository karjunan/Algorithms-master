package threads.basic;

public class ThreadExample extends Thread {

    @Override
    public void run() {
        int i = 0;
        while(i < 1) {
            System.out.println(i + " == " + this.getName());
            i += 1;
        }
    }
}

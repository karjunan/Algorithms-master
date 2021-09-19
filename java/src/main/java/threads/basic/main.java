package threads.basic;

public class main {

    public static void main(String[] args) {
        Runtime.getRuntime().gc();
/*        ThreadExample example = new ThreadExample();
        ThreadExample1 example1 = new ThreadExample1();
        example.start();
        example1.start();*/


    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("calling finalized");
    }
}

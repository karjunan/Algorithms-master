package staticConcepts;

public class StaticExample {


    public static void main(String[] args) {
        {
            System.out.println(" this is higher than that the normal static ");
        }
        test();
        StaticExample example =  new StaticExample();
        new StaticExample().test1();
    }



    static {
        System.out.println(" this is high level static ");
    }
    public static void test() {
        StaticExample example  = new StaticExample();
        System.out.println("this is a static method");
    }

    public void test1() {

        test();
        System.out.println("this is a non static method");
    }
}

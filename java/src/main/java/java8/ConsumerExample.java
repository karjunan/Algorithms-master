package java8;

public class ConsumerExample {

    public static void main(String[] args) {

        ConsumerFunctionInterface inter = (name) -> {System.out.println(name);};

        inter.accept("test");
    }
}

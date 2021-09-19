package advancedJava.functionalInterface;

public class main {

    public static void main(String[] args) {

        Greetings greetings = (name) -> System.out.println(name);

        greetings.greet("Krishna");
    }
}

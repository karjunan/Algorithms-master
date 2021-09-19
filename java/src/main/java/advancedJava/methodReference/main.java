package advancedJava.methodReference;

public class main {

    public static void main(String[] args) {
        Square square = new Square(10);

//        Shape shape = (sq) -> {
//            return sq.calculate();
//        };

        Shape shape = Square::calculate;
        System.out.println("Result is ===> " + shape.getArea(square));
    }
}

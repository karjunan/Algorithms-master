package designPatterns.liskovsSubstitutionPrinciple.example2;

public class demo {

    public static void main(String[] args) {

        Rectangle rt = new Rectangle(2,3);
        useIt(rt);

        Rectangle square = new Square(3);
        useIt(square);

    }

    public static void useIt(Rectangle rt) {

        int width = rt.getWidth();
        rt.setHeight(10);

        System.out.println("Expected Area => " + (width*10) + "  == but got  " + rt.getArea() );
    }
}

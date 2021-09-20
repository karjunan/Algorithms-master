package designPatterns.liskovsSubstitutionPrinciple.example2;

public class Square extends Rectangle {

    public Square() {

    }

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}

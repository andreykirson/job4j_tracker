package strategy;

public class Paint {

    public static void main(String[] args) {
        Square square = new Square();
        Triangle triangle = new Triangle();
        System.out.println(square.draw());
        System.out.println(triangle.draw());
    }

    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }
}

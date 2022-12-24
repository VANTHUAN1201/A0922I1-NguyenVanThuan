package abstract_interface.resizeable;

public class Test {
    public static void main(String[] args) {
        double percent=Math.random() * 100;
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5,10);
        shapes[2] = new Square(20);
        System.out.println("percent= "+percent);
        for (Shape a : shapes){
            System.out.println("Before:"+a);
            a.resize(percent);
            System.out.println("After:"+a);

        }
    }
}

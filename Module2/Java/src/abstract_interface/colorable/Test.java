package abstract_interface.colorable;

public class Test {
    public static void main(String[] args) {
        Shape shapes[] = new Shape[6];
        shapes[0] = new Rectangle(5,7);
        shapes[1] = new Rectangle(10,20);
        shapes[2] = new Circle(6.5);
        shapes[3] = new Circle(10.5);
        shapes[4] = new Square(10.5);
        shapes[5] = new Square(15.25);

        Colorable colorable = new Square();
        for (Shape i : shapes){
            System.out.println(i.toString());
            if (i instanceof Colorable){
                colorable.howToColor();
            }
        }
    }
}

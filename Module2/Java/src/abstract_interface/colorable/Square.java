package abstract_interface.colorable;

public class Square extends Shape implements Colorable {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return getSide() * getSide();
    }

    @Override
    public String toString() {
        return "Square{" + "side=" + getSide() + " , Area: " + getArea() + "  }.";
    }

    @Override
    public void howToColor() {
        System.out.println(" Color: red.");
    }
}

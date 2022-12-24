package access_modifier.circle;

public class Circle {
    private double radius=1.0;
    private String color="red";
    public Circle(){
    }
    Circle(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return (3.14*radius*radius);
    }
}

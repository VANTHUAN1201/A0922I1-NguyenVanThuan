package inheritance.circle;

public class DemoCircle {
    public static void main(String[] args) {
        Circle c1= new Cylinder();
        Circle c2=new Cylinder(5f);
        Circle c3=new Cylinder(5f,"red",10f);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}

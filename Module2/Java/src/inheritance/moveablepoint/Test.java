package inheritance.moveablepoint;

public class Test {
    public static void main(String[] args) {
        Point point=new Point(10,20);
        MoveablePoint moveablePoint=new MoveablePoint(10,20,30,30);
        System.out.println(point);
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}

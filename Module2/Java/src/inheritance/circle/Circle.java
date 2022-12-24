package inheritance.circle;

public class Circle {
    public float radius;
    public String color;

    public Circle() {
    }

    public Circle(float radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public float area(float radius){
        return (float) (3.14*this.radius*this.radius);
    }
    public String toString(){
        return "Bán kính: "+this.radius+"\nMàu sắc: "+this.color+"\nDiện tích:"+area(this.radius) ;
    }
}

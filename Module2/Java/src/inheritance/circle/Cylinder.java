package inheritance.circle;

import inheritance.circle.Circle;

public class Cylinder extends Circle {
    public float height;

    public Cylinder() {
    }

    public Cylinder(float height) {
        this.height = height;
    }

    public Cylinder(float radius, String color, float height) {
        super(radius, color);
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    public float volume(float height,float area){
        return (this.height*super.area(radius));
    }

    @Override
    public java.lang.String toString() {
        return super.toString()+"\nThể tích hình trụ la:"+volume(this.height,super.area(radius));
    }
}

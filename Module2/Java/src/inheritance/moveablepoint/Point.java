package inheritance.moveablepoint;

public class Point {
    public float x;
    public float y;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float X, float Y) {
        setX(X);
        setY(Y);
    }

    public float[] getXY() {
        float[] arr = {getX(), getY()};
        return arr;
    }

    @Override
    public String toString() {
        return "Point{" + getX() + ", " + getY() + "}";
    }
}

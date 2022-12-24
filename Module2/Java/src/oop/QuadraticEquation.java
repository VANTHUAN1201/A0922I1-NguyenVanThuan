package oop;

import java.util.Scanner;

class QuadreticEquationClass{
    private double a;
    private double b;
    private double c;

    public QuadreticEquationClass() {
    }

    public QuadreticEquationClass(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    float getDiscriminant(){
        float delta= (float) (b*b-4*a*c);
        return delta;
    }
    double getRoot1(){
        double r1= ((-b)+Math.sqrt(getDiscriminant()))/(2*a);
        return r1;
    }
    double getRoot2(){
        double r2= ((-b)-Math.sqrt(getDiscriminant()))/(2*a);
        return r2;
    }
    void result(){
        if(getDiscriminant()>=0){
            System.out.println("the root1 is: "+getRoot1());
            System.out.println("the root2 is: "+getRoot2());
        }else{
            System.out.println("no root");
        }
    }
}
public class QuadraticEquation {
    public static void main(String[] args) {
        float a,b,c;
        Scanner sc=new Scanner(System.in);
        System.out.println("input a: ");
        a=Float.parseFloat(sc.nextLine());
        System.out.println("input b: ");
        b=Float.parseFloat(sc.nextLine());
        System.out.println("input c: ");
        c=Float.parseFloat(sc.nextLine());
        QuadreticEquationClass quad =new QuadreticEquationClass(a,b,c);
        quad.result();
    }
}

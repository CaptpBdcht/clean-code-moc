import static java.lang.StrictMath.sqrt;

public class Point {
    private double x;
    private double y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Double norme (){
        return sqrt(this.x * this.x + this.y * this.y);
    }
}

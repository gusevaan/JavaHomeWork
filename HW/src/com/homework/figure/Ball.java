package com.homework.figure;

public class Ball extends FigureAbstract {
    double radius;

    public Ball(double radius) {
        super(volume, area);
        this.radius = radius;
    }
    @Override
    public void getVolume(){
        volume = 1.333333333333333 * Math.PI * (radius * radius * radius);
    }

    @Override
    public void getArea(){
        area = 4 * Math.PI * (radius*radius);
        //S = 4 * Math.PI * (r*r)
    }

    @Override
    public String toString() {
        return "Ball{" +
                "Объем=" + volume +
                ", площадь=" + area +
                '}';
    }
}

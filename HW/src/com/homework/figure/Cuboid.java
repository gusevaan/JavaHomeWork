package com.homework.figure;

public class Cuboid  extends FigureAbstract {
    double length; //a
    double width; //b
    double height; //c

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public Cuboid(double length, double width, double height) {
        super(volume,area);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void getVolume(){
        this.volume = length * width * height;
        //V = abc
    }
    public void getArea(){
        area = 2 * (length *width + width * height + length * height);
    }

    @Override
    public String toString() {
        return "Сuboid{" +
                "Объем=" + volume +
                ", площадь=" + area +
                '}';
    }
}

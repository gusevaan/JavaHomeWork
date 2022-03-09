package com.homework.figure;

public abstract class FigureAbstract {
    protected static double volume;
    protected static double area;

    public FigureAbstract(double volume, double area) {
        this.volume = volume;
        this.area = area;
    }

    public abstract void getArea();
    public abstract void getVolume();
}

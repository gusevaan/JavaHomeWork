package com.homework.figure;

public class Cube  extends FigureAbstract {
    double lenght;
    public void getVolume(){
        volume = lenght * lenght * lenght;
    }

    public Cube(double lenght) {
        super(volume,area);
        this.lenght = lenght;
    }

    public void getArea(){
        area = 6 * (lenght * lenght);
        //S = 6 ⋅ a2 (длина стороны куба)
    }

    @Override
    public String toString() {
        return "Cube{" +
                "Объем=" + volume +
                ", площадь=" + area +
                '}';
    }
}

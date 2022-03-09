package com.homework.figure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner ballParameters = new Scanner(System.in);
        System.out.println("Введите радиус шара: "); //10
        double radius = ballParameters.nextDouble();

        Ball ball = new Ball(radius);
        ball.getVolume();ball.getArea();
        System.out.println(ball.toString());

        Scanner cubeParameters = new Scanner(System.in);
        System.out.println("Введите длину куба: ");
        double cubeLenght = cubeParameters.nextDouble();

        Cube cube = new Cube(cubeLenght);
        cube.getArea();
        cube.getVolume();
        System.out.println(cube.toString());

        Scanner cuboidParameters = new Scanner(System.in);
        System.out.println("Введите длину, ширину, высоту: ");
        double cuboidLenght = cuboidParameters.nextDouble();
        double cuboidWidth = cuboidParameters.nextDouble();
        double cuboidHeight = cuboidParameters.nextDouble();

        Cuboid cuboid = new Cuboid(cuboidLenght,cuboidWidth,cuboidHeight);
        cuboid.getArea();
        cuboid.getVolume();
        System.out.println(cuboid.toString());

    }
}

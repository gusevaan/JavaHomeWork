package com.homework.quadraticsolution;
import java.util.Scanner;
public class QuadraticSolution {
    double D;
    double a, b, c;


    public void getSolution(){
        a = 2;
        b = 10;
        c = 44;
        D = b * b - 4 * a * c;
        if (D > 0)
        {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Корни: x1 = " + x1 + ", x2 = " + x2);
        }
        else if (D == 0)
        {
            double x;
            x = -b / (2 * a);
            System.out.println("Один корень: x = " + x);
        }
        else
        {
            System.out.println("Нет корней");
        }
    }
}

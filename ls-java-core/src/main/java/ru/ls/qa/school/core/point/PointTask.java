package ru.ls.qa.school.core.point;

public class PointTask {
    public static void main(String[] args) {
      Point firstPoint = new Point(3,4);
      Point secondPoint = new Point(6,8);
        System.out.println("Расстояние между точкой 1 и точкой 2: " + firstPoint.distance(secondPoint));
    }
}

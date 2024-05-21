package ru.ls.qa.school.core.point;

import lombok.Data;

@Data
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        int degree = 2;
        return  Math.sqrt(Math.pow((point.getX() - this.x), degree) + Math.pow((point.getY() - this.y), degree));
    }

}

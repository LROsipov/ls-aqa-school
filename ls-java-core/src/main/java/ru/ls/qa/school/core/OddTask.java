package ru.ls.qa.school.core;

public class OddTask {
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(OddTask.isOdd(4));
    }
}

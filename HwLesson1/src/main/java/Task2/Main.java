// Написать метод, который определяет, является ли введенный пользователем год високосным,
// и возвращает в консоль boolean (високосный - true, не високосный - false).
// Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LeapYear();
    }

    public static void LeapYear() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        Boolean b = false;
        if (year % 4 == 0) {
            b = true;
        }
        if (year % 100 == 0) {
            b = false;
        }
        if (year % 400 == 0) {
            b = true;
        }
        System.out.println(b);
    }
}

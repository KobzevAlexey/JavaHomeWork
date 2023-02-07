// Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.

package Task2;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        flipOver();
    }

    private static void flipOver() {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        int size = 5;
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("Исходный список: ");
        list.forEach(System.out::println);
        System.out.println("Перевёрнутый список: ");
        list.descendingIterator().forEachRemaining(System.out::println);
    }
}
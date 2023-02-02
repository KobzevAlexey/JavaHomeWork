// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.

package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = GetList();
        FindMax(list);
        FindMin(list);
        FindAverage(list);

    }

    public static List<Integer> GetList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        return list;
    }

    public static void FindMax(List<Integer> list) {
        int max = Collections.max(list);
        System.out.println("Максимальное значение = " + max);
    }

    public static void FindMin(List<Integer> list) {
        int min = Collections.min(list);
        System.out.println("Минимальное значение = " + min);
    }

    public static void FindAverage(List<Integer> list) {
        double average = list.stream().mapToInt(val -> val).average().orElse(0.0);
        System.out.println("Среднее значение = " + average);
    }
}
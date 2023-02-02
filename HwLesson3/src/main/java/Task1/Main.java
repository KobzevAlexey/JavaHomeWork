// Пусть дан произвольный список целых чисел, удалить из него четные числа

package Task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RemoveEvenNumbers();
    }

    public static List<Integer> GetList() {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            nums.add(random.nextInt(100));
        }
        System.out.println(nums);
        return nums;
    }

    public static void RemoveEvenNumbers() {
        List<Integer> nums = GetList();
        nums.removeIf(x -> x % 2 == 0);
        System.out.println(nums);
    }
}

// Задать одномерный массив и найти в нем минимальный и максимальный элементы

package Task1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FindMaxMin();
    }

    public static int[] GetArray() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void FindMaxMin() {
        int[] arr = GetArray();
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Максимальный элемент = " + max + ", минимальный элемент = " + min);
    }
}
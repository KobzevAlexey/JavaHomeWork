// Дан массив nums = [3,2,2,3] и число val = 3.
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

package Task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SortArray();
    }

    public static void SortArray() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int left = 0;
        int right = nums.length - 1;
        boolean found = Arrays.stream(nums).anyMatch(i -> i == val);
        if (found) {
            if (nums[left] == val && nums[right] == val) {
                right--;
            }
            while (left < right) {
                if (nums[left] == val && nums[right] != val) {
                    var temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
                right--;
                if (nums[left] != val) {
                    left++;
                }
                if (nums[right] == val) {
                    right--;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
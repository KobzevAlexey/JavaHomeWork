// Напишите метод, который принимает на вход строку (String) и определяет
// является ли строка палиндромом (возвращает boolean значение).
package Task1;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GetString();
    }

    public static void GetString() {
        Scanner sc = new Scanner(System.in);
        String UserStr = sc.nextLine();
        String str1 = UserStr.replaceAll(" ", "");
        String str2 = str1.replaceAll(",", "");
        StringBuilder sb = new StringBuilder(str2);
        sb.reverse();
        boolean b = str2.equalsIgnoreCase(String.valueOf(sb));
        System.out.println(b);
    }
}

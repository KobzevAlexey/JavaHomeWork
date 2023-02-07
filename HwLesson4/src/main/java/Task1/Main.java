// Реализовать консольное приложение, которое:
// Принимает от пользователя и “запоминает” строки.
// Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
// Если введено revert, удаляет предыдущую введенную строку из памяти.

package Task1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getString();
    }

    private static void getString() {
        LinkedList<String> words = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите текст: ");
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("print")) {
                if (words.size() > 0) {
                    System.out.println("Список строк:");
                    for (int i = words.size() - 1; i >= 0; i--) {
                        System.out.println(words.get(i));
                    }
                } else {
                    System.out.println("Список пуст");
                }
            } else if (str.equalsIgnoreCase("revert")) {
                try {
                    System.out.println("Удалена строка: " + words.get(words.size() - 1));
                    words.remove(words.size() - 1);

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Список пуст");
                }
            } else if (str.equalsIgnoreCase("exit")) {
                break;
            } else {
                words.add(str);
                System.out.println("Добавлена строка: " + str);
            }
        }
    }
}

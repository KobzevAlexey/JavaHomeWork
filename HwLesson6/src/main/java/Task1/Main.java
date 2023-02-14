package Task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Laptop asus = new Laptop("ASUS",
                "D543MA-DM1368",
                "Intel UHD Graphics",
                "Intel Celeron N4020",
                "4");
        Laptop acer = new Laptop("ACER",
                "Aspire 7 A715-42G-R44J",
                "GeForce RTX 3050 Ti",
                "AMD Ryzen 5 5500U",
                "8");
        Laptop msi = new Laptop("MSI",
                "Katana GF76 11SC-853XRU",
                "GeForce GTX 1650",
                "Intel Core i5-11400H",
                "16");
        Laptop dell = new Laptop("DELL",
                "G15 5515",
                "GeForce RTX 3060",
                "AMD Ryzen 7 5800H",
                "16");
//        LinkedList<Laptop> allLaptops = new LinkedList<>();
//        allLaptops.add(asus);
//        allLaptops.add(acer);
//        allLaptops.add(msi);
//        allLaptops.add(dell);
        Set<Laptop> laptops = new HashSet<>(List.of(asus, acer, msi, dell));
        Map<String, String> sel = selectCriteria();
        sort(sel, laptops);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
            System.out.println("Вы хотите выбрать критерий? Если да введите 'y', если нет введите 'n'");
            String question = scanner();
            if (question.equals("n")) {
                break;
            } else {

                System.out.println(
                        "Введите цифру, соответствующую необходимому критерию: \n 1 - Бренд \n 2 - Модель \n 3 - GPU \n 4 - CPU \n 5 - RAM");
                String key = scanner();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner();

                resultCriterias.put(key, value);
            }
        }
        System.out.println(resultCriterias);
        return resultCriterias;

    }

    public static void sort(Map<String, String> criterias, Set<Laptop> laptops) {

        Set<Laptop> temp = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {

            for (Object pair : criterias.keySet()) {

                if (pair.equals("1") && !laptop.getBrand().equals(criterias.get(pair))) {
                    temp.remove(laptop);
                }
                for (Object pair1 : criterias.keySet()) {

                    if (pair1.equals("2") && !laptop.getModel().equals(criterias.get(pair1))) {
                        temp.remove(laptop);

                    }
                    for (Object pair2 : criterias.keySet()) {

                        if (pair2.equals("3") && !laptop.getGpu().equals(criterias.get(pair2))) {
                            temp.remove(laptop);

                        }
                        for (Object pair3 : criterias.keySet()) {

                            if (pair3.equals("4") && !laptop.getCpu().equals(criterias.get(pair3))) {
                                temp.remove(laptop);

                            }
                            for (Object pair4 : criterias.keySet()) {

                                if (pair4.equals("5") && !laptop.getRam().equals(criterias.get(pair4))) {
                                    temp.remove(laptop);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        } else {
            System.out.println("Вот что мы можем предложить: \n" + temp);
        }
    }
}
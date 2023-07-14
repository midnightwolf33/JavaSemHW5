// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут
// повторяющиеся имена с разными телефонами, их необходимо считать,
// как одного человека с разными телефонами. Вывод должен быть отсортирован
// по убыванию числа телефонов.
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;

public class seminar5homework{
    Scanner sc = new Scanner(System.in, "cp866");
    public static void main(String[] args) {       
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in, "cp866");
        int input = 0;
        while (input != 4) {
            System.out.print(
                    "Доступные действия:\n [1] - Добавить запись\n [2] - Найти запись\n [3] - Показать все записи\n [4] - Выход\n ---> ");
            input = Integer.valueOf(sc.nextLine());
            switch (input) {
                case 1:
                    phoneBook = AddRecord(phoneBook);
                    break;
                case 2:
                    FindRecord(phoneBook);
                    break;
                case 3:
                    PrintRecords(phoneBook);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Выбрать правильные варианты.");
                    break;
            }
        }
        sc.close();
    }

    public static Map<String, ArrayList<String>> AddRecord(Map<String, ArrayList<String>> phoneBook) {
        try (Scanner sc = new Scanner(System.in, "cp866")) {
            System.out.print("Введите фамилию: ");
            String name = sc.nextLine();
            System.out.print("Введите номер телефона: ");
            String phone = sc.nextLine();
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phone);
            } else {
                phoneBook.put(name, new ArrayList<String>());
                phoneBook.get(name).add(phone);
            }
        }
        return phoneBook;
    }

    public static void FindRecord(Map<String, ArrayList<String>> phoneBook) {
        try (Scanner sc = new Scanner(System.in, "cp866")) {
            System.out.print("Введите фамилию для поиска: ");
            String search = sc.nextLine();
            for (Map.Entry<String, ArrayList<String>> item : phoneBook.entrySet()) {
                if (search.equals(item.getKey())) {
                    System.out.print("Искомая запись: " + item.getKey() + " : " + item.getValue() + "\n");
                } else {
                    System.out.println("Искомая запись отсутствует.");
                }
            }
        }
    }

    public static void PrintRecords(Map<String, ArrayList<String>> phoneBook) {
        SortedSet<Map.Entry<String, ArrayList<String>>> sortedset = new TreeSet<Map.Entry<String, ArrayList<String>>>(
                new Comparator<Entry<String, ArrayList<String>>>() {
                    public int compare(Entry<String, ArrayList<String>> arg0,
                            Entry<String, ArrayList<String>> arg1) {
                        if (arg0.getValue().size() < arg1.getValue().size())
                            return 1;
                        else if (arg0.getValue().size() > arg1.getValue().size())
                            return -1;
                        else
                            return 1;
                    }
                });
        sortedset.addAll(phoneBook.entrySet());
        for (Map.Entry<String, ArrayList<String>> item : sortedset) {
            System.out.println(item.getKey() + " : " + item.getValue() + "\n");
        }
    }
}

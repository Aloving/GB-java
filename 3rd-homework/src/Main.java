import java.util.*;

public class Main {
    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    public static void firstTask() {
        StringList strList = new StringList("a", "b", "v", "g", "g", "b");

        for (String word : strList.getUnique()) {
            System.out.println(word);
        }

        Map<String, Integer> uniqueCount = strList.countUnique();
        for (Map.Entry<String, Integer> item: uniqueCount.entrySet()) {
            System.out.printf(String.format("\"%s\": %d", item.getKey(), item.getValue()));
        }
    }

    public static void secondTask() {
        AddressBook addressBook = new AddressBook();

        addressBook.add("Aleksey", "+123");
        addressBook.add("Aleksey", "+1234");
        addressBook.add("Aleksey", "+12344");
        addressBook.add("John", "+9231");

        for (Map.Entry<String, Set<String>> address : addressBook.book.entrySet()) {
            // Synthetic logic to test AddressBook::get method
            String lastName = address.getKey();
            String[] phones = addressBook.get(lastName);
            System.out.println(lastName);
            System.out.println(String.join(", ", phones));
        }
    }
}

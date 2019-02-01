import java.util.*;

public class AddressBook {
    Map<String, Set<String>> book = new HashMap<>();

    public Map<String, Set<String>> add(String name, String number) {
        book.merge(
            name,
            new HashSet<String>(Arrays.asList(number)),
            (a, b) -> {
                a.addAll(b);
                return a;
            });

        return this.book;
    }

    String[] get(String name) {
        return book.get(name).toArray(new String[]{});
    }
}

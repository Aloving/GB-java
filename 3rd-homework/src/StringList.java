import java.util.*;

public class StringList {
    private List<String> list;

    public StringList(String ...list) {
        this.list = Arrays.asList(list);
    }

    public String[] getUnique() {
        List<String> unique = new ArrayList<String>();
        Map<String, Integer> counts = this.countUnique();

        Set<String> keys = counts.keySet();

        for (String key : keys) {
            if (counts.get(key) == 1) {
                unique.add(key);
            }
        }

        return unique.toArray(new String[]{});
    }

    public Map<String, Integer> countUnique() {
        Map<String, Integer> countMap = new HashMap<>();

        for (String word : list) {
            if(countMap.containsKey(word)) {
                Integer wordCount = countMap.get(word);
                countMap.put(word, wordCount + 1);
            } else {
                countMap.put(word, 1);
            }
        }

        return countMap;
    }
}

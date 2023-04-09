package HashTableSearch;

import java.util.HashMap;

public class HashTableSearch {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("cherry", 300);

        int value = getValueByKey(map, "banana");
        if (value == -1) {
            System.out.println("Key not found in the map.");
        } else {
            System.out.println("Value of the key 'banana': " + value);
        }
    }

    public static int getValueByKey(HashMap<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }
}
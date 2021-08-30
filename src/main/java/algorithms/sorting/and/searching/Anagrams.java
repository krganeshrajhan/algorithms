package algorithms.sorting.and.searching;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    public static HashMap < String, List< String >> groupAnagrams(String arr[]) {
        HashMap < String, List< String >> myMap = new HashMap< >();
        for(String str : arr) {
            String hashString = getHash(str);
            List<String> strings = myMap.getOrDefault(hashString, new ArrayList<>());
            strings.add(str);
            myMap.put(hashString, strings);
        }
        return myMap;
    }

    private static String getHash(String str) {
        Map<Character, Integer> characterMap = new TreeMap<>();
        for(char ch : str.toCharArray()) {
            Integer count = characterMap.getOrDefault(ch, 0);
            characterMap.put(ch, count+1);
        }
        return characterMap.entrySet().stream().map(entry -> new String(entry.getKey()+entry.getValue().toString())).collect(Collectors.joining("#"));
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"cat", "dog", "tac", "god", "act", "tom marvolo riddle ", "abc", "def", "cab",
                "fed", "clint eastwood ", "i am lord voldemort", "elvis", "old west action", "lives"};
        HashMap<String, List<String>> myMap = groupAnagrams(strings);
        printMap(myMap);
    }

    private static void printMap(HashMap<String, List<String>> myMap) {
        myMap.entrySet().stream().forEach(stringListEntry -> {
            System.out.println(stringListEntry.getKey());
            System.out.println(stringListEntry.getValue().stream().collect(Collectors.joining(",")));
        });
    }

}

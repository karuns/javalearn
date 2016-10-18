import java.util.*;

class Solution {

    private static String getKey(String title) {
        int[] ch = new int[26];
        for(char c: title.toCharArray()) {
            ch[c-'a']++;
        }
        return Arrays.toString(ch);
    }

    public static void main(String[] args) {
        String[] input = {"duel", "dule", "speed", "spede", "deul", "cars"};
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String title: input) {
            String key = getKey(title);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(title);
        }

//        for(String k: map.keySet()) {
//            System.out.println(map.get(k));
//        }

        String searchTitle = "duel";
        System.out.println(map.get(getKey(searchTitle)));
    }
}

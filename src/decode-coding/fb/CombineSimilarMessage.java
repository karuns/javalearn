// https://www.educative.io/courses/decode-coding-interview-java/JE7o9jZGJVP

import java.util.*;

class CombineSimilarMessage {

    public static String getKey(String message) {
        String key = "";
        for(int i = 1; i < message.length(); i++) {
            int val = message.charAt(i) - message.charAt(i-1);
            if(val < 0) val += 26;
            key = key+val+",";
        }
        System.out.println(key);
        return key;
    }

    public static List<List<String>> combineMessages(String[] messages) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String message: messages) {
            String key = getKey(message);
            List<String> temp = map.getOrDefault(key, new ArrayList<>());
            temp.add(message);
            map.put(key, temp);
        }
        return new ArrayList<>(map.values());
    }

    public static void main( String args[] ) {
        // Driver code

        String[] messages = {"lmn", "mno", "azb", "bac", "yza", "bdfg"};
        List<List<String>> groups = combineMessages(messages);

        System.out.println("The Grouped Messages are:\n");
        for (List<String> group : groups)
            System.out.println(group);
    }
}

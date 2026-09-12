package week1.practice_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }
        
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return '\0';
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar finder = new FirstNonRepeatingChar();
        String[] words = {"swiss", "aabbcc"};
        
        for (String word : words) {
            char result = finder.findFirstNonRepeatingChar(word);
            if (result == '\0') {
                System.out.println("\"" + word + "\" No Non-Repeating Character Found");
            } else {
                System.out.println("\"" + word + "\" First Non-Repeating Character: '" + result + "'");
            }
        }
    }
}

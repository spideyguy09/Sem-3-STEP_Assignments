package week2.assigment_problems;

import java.util.*;

public class StopWordFilteredWordFrequencyReport {
    public void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.isEmpty()) {
            return;
        }

        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        
        // Normalize: lowercase and strip punctuation (periods and commas)
        String normalized = feedback.toLowerCase().replace(".", "").replace(",", "");
        
        // Split into words
        String[] words = normalized.split("\\s+");
        
        // Count frequencies
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by count in descending order
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounts.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        // Print result
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StopWordFilteredWordFrequencyReport report = new StopWordFilteredWordFrequencyReport();
        report.printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}

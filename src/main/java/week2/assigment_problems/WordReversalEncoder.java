package week2.assigment_problems;

public class WordReversalEncoder {
    public String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse();
            
            result.append(reversedWord.toString());
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        WordReversalEncoder encoder = new WordReversalEncoder();
        encoder.reverseEachWord("hello club");
    }
}

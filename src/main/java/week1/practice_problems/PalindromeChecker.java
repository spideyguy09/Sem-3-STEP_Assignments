package week1.practice_problems;

public class PalindromeChecker {

    public boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String cleanText = text.toLowerCase();
        int left = 0;
        int right = cleanText.length() - 1;
        
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        String cleanText = text.toLowerCase();
        return checkRecursive(cleanText, 0, cleanText.length() - 1);
    }
    
    private boolean checkRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return checkRecursive(text, left + 1, right - 1);
    }

    public boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String cleanText = text.toLowerCase();
        char[] chars = cleanText.toCharArray();
        
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        String reversed = new String(chars);
        return cleanText.equals(reversed);
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        String[] words = {"madam", "hello"};
        
        for (String word : words) {
            boolean iter = checker.isPalindromeIterative(word);
            boolean rec = checker.isPalindromeRecursive(word);
            boolean arr = checker.isPalindromeArrayReversal(word);
            
            System.out.printf("\"%s\" Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                    word,
                    iter ? "Palindrome" : "Not Palindrome",
                    rec ? "Palindrome" : "Not Palindrome",
                    arr ? "Palindrome" : "Not Palindrome");
        }
    }
}

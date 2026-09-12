package week1.practice_problems;

public class ReverseCustomerName {

    public String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseCustomerName reverser = new ReverseCustomerName();
        String original = "Sunil";
        String reversed = reverser.reverseCustomerName(original);
        
        System.out.println("\"" + original + "\" Original Name: " + original);
        System.out.println("Reversed Name: " + reversed);
    }
}

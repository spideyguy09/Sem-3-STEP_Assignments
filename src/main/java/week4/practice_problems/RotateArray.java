package week4.practice_problems;
import java.util.Arrays;
public class RotateArray {
    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        // Copy back
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
        return nums;
    }
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(ra.rotateArray(nums, 3)));
    }
}

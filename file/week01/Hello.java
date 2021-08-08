import java.util.ArrayList;
import java.util.List;

public class Hello {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(10);
        nums.add(12);
        for (Integer num : nums) {
            if (num > 10) {
                int sum = nums.get(0) + num;
                int result = sum - 30;
                System.out.println(result);
            }
        }
    }
}

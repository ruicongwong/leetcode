package array;

public class SingleNumbers {
}

class SolutionLc56 {
    public int[] singleNumbers(int[] nums) {
        int z = 0;
        for (int num : nums) {
            z ^= num;
        }

        int m = 1;
        while (((z & m) == 0)) m <<= 1;
        int x = 0;
        int y = 0;
        for (int num : nums) {
            if ((num & m) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x ,y};
    }
}
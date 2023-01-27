import java.util.Arrays;

public class test {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        //特例判断
        if (sum%2 == 1) {
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];//这里的dp相当于二维数组中的第一层。初始化时二维数组自动填充了false
        System.out.print(Arrays.toString(dp));
        //初始化
        dp[0] = true;
        dp[nums[0]] = true;
        System.out.print(Arrays.toString(dp));

        for (int i = 1; i < nums.length; i += 1) {
            boolean[] dp1 = new boolean[target+1];
            for (int j = 0; j < target+1; j += 1) {
                if (nums[i] > j) {
                    dp1[j] = dp[j];
                } else {
                    dp1[j] = (dp[j] || dp[j-nums[i]]);
                }
            }
            dp = dp1;
            System.out.print(Arrays.toString(dp));
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[]nums = {1,2,5};
        canPartition(nums);

    }
}

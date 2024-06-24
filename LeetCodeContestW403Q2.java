import java.util.*;

public class LeetCodeContestW403Q2 {
    private long dp[][];
    private long f(int i, int j, int[] a) {
        if (i == j) return a[i];
        if (j - i + 1 == 2) {
            return Math.max(a[i] - a[j], a[i] + a[j]);
        }
        if (dp[i][j] != -1) return dp[i][j];
        long max = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long left = f(i, k, a);
            long right = f(k + 1, j, a);
            max = Math.max(max, left + right);
        }
        return dp[i][j] = max;
    }

    public long maximumTotalCost(int[] nums) {
        dp = new long[nums.length][nums.length];
        for(long i[]:dp)
        Arrays.fill(i, -1);
        return f(0, nums.length - 1, nums);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LeetCodeContestW403Q2 l = new LeetCodeContestW403Q2();
		ArrayList<Integer>a = new ArrayList<>();
		while (sc.hasNext())a.add(sc.nextInt());
		int nums[] = new int[a.size()];
		for (int i = 0; i < a.size(); i++)nums[i] = a.get(i);
		System.out.println(l.maximumTotalCost(nums));
	}
}
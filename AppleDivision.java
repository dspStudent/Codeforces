import java.io.*;
import java.util.*;
import java.util.stream.*;
public class AppleDivision {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;

	private static void printEl(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	public boolean f(int i, int sum, int a[], int[][]dp) {
		if (i < 0) {
			if (sum == 0)return true;
			return false;
		}
		if (dp[i][sum] != -1)return dp[i][sum] == 1;

		boolean tf = false;
		tf = f(i - 1, sum, a, dp);
		if (sum - a[i] >= 0)
			tf = tf || f(i - 1, sum - a[i], a, dp);
		dp[i][sum] = tf ? 1 : 0;
		System.out.println(i + " " + sum + " " + dp[i][sum]);
		return dp[i][sum] == 1;
	}
	public int run1(int a[]) {
		int n = a.length;
		long sum = Arrays.stream(a).mapToLong(i->(long)i).sum();
		// op.append(sum).append("\n");
		// if(sum%2==0)return 2;

		int dp[][];
		int siz = (int)(sum + 1);
		dp = new int[n][siz];
		for (int i[] : dp)Arrays.fill(i, 0);
		dp[0][0] = 1;
		for (int i = 0; i < n; i++)dp[i][a[i]] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= sum; j++) {
				boolean tf = dp[i - 1][j] == 1;
				if (j - a[i] >= 0) {
					tf = tf || dp[i - 1][j - a[i]] == 1;
				}
				dp[i][j] = tf ? 1 : 0;
			}
		}
		// op.append(tf).append("\n");

		int end = dp[0].length / 2;

		int left = end - 1;
		if (sum % 2 == 0)end += 1;
		// LongStream.range(0, sum).forEach(i->op.append(i+"    "));
		// op.append("\n");
		// System.out.println(left+" "+end);
		// for(int i=0;i<n;i++)

		while (left >= 0 && end < dp[0].length) {
			// op.append(left+" "+end+" "+dp[n-1][left]+" "+dp[n-1][end]).append("\n");
			if (dp[n - 1][left] == 1 && dp[n - 1][end] == 1) {
				return Math.abs(left - end);
			}
			left--; end++;
		}
		if (sum % 2 == 0)return 0;

		return -1;
	}

	List<List<Integer>>set;
	public void f(int i, int sum, int a[], ArrayList<Integer>li) {
		if (i == a.length) {
			li.add(sum);
			set.add(new ArrayList<>(li));
			li.remove(li.size() - 1);
			return;
		}
		li.add(a[i]);
		f(i + 1, sum + a[i], a, li);
		li.remove(li.size() - 1);
		f(i + 1, sum, a, li);
	}
	public int run2(int a[]) {
		int n = a.length;
		set = new ArrayList<>();
		f(0, 0, a, new ArrayList<>());
		op.append(set).append("\n");
		return 0;
	}










	public long run(int a[]) {
		int n=a.length;
		long best=Long.MAX_VALUE;
		long firstSum=0, secSum=0;
		for(int i=0;i<(1<<n);i++){
			int j=i;
			firstSum=0;
			secSum=0;
			for(int k=0;k<n;k++){
				if(((j>>(k))&1)==1)firstSum+=a[k];
				else secSum+=a[k];
			}
			best=Math.min(best, Math.abs(firstSum-secSum));
		}
		return best;
	}















	public static void main(String[] args) throws IOException {
		AppleDivision o = new AppleDivision();
		int n = sToInt(br.readLine());
		int a[] = nextIntA(n);

		op.append(o.run(a)).append("\n");

		System.out.println(op);
	}






//  sum-x x
















	public static int[] nextIntA(int n)throws IOException {
		int a[] = new int[n];
		st = nst(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = sToInt(st.nextToken());
		}
		return a;
	}
	public static int sToInt(String s) {
		return Integer.parseInt(s);
	}
	public static long sToLong(String s) {
		return Long.parseLong(s);
	}
	public static int sToInt(char c) {
		return Integer.parseInt(c + "");
	}
	public static long sToLong(char c) {
		return Long.parseLong(c + "");
	}
	public static StringTokenizer nst(String s) {
		return new StringTokenizer(s);
	}
}
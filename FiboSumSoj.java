import java.io.*;
import java.util.*;
public class FiboSumSoj {
	final static long MOD = 1000000007;
	private long[][] matPower(long a[][], int b) {
		long res[][] = {
			{1, 0, 0},
			{0, 1, 0},
			{0, 0, 1}
		};
		while (b != 0) {
			if ((b & 1) == 1)res = matMul(res, a);
			a = matMul(a, a);
			b = b >> 1;
		}
		return res;
	}
	private long[][] matMul(long [][]a, long [][]b) {
		long res[][] = new long[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					res[i][j] = (res[i][j] + (a[i][k] % MOD * b[k][j] % MOD) % MOD) % MOD;
				}
			}
		}

		return res;
	}
	private long f(long n) {
		long [][]t = {
			{1, 1, 1},
			{0, 1, 1},
			{0, 1, 0}
		};
		long [][]fn = {
			{1},
			{1},
			{0}
		};
		long res[][] = matMul(matPower(t, (int)n), fn);

		return res[0][0] % MOD;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer syso = new StringBuffer();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			FiboSumSoj fs = new FiboSumSoj();
			long n = Long.parseLong(st.nextToken()), m = Long.parseLong(st.nextToken());
			long fn = 0, fm = 0;
			if (n >= 2)fn = fs.f(n - 2);
			if (m >= 1)fm = fs.f(m - 1);

			long ans = fm - ((n == 1) ? 1 : fn);
			syso.append((ans+MOD)%MOD).append("\n");
		}
		System.out.println(syso);
	}
}

// t power(n-2)*mat=sn-1

// t power(m-1)*mat=sm;

// sm-sn-1=ans;


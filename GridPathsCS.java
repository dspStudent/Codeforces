import java.io.*;
import java.util.*;
public class GridPathsCS {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;

	//                        u,  d,  l, r


	boolean vis[][];

	public static int[] dr = { -1, 1,  0, 0};

	public static int[] dc = {0, 0, -1, 1};

	int paths = 0;
	public void solve(String s, int i, int j, int k) {

		if (i == 6 && j == 0) {
			if (k == 48) {
				paths++;
			}
			return;
		}


		if (vis[i][j] || k > 48)return;

		boolean hitWall = (i == 0 && (j >= 1 && j <= 5) && !vis[i][j - 1] && !vis[i][j + 1] && vis[i + 1][j]) ||
		                  (i == 6 && (j >= 1 && j <= 5) && !vis[i][j - 1] && !vis[i][j + 1] && vis[i - 1][j] ) ||

		                  (j == 0 && (i >= 1 && i <= 5) && !vis[i - 1][j] && !vis[i + 1][j] && vis[i][j + 1]) ||
		                  (j == 6 && (i >= 1 && i <= 5) && !vis[i - 1][j] && !vis[i + 1][j] && vis[i][j - 1]) ||

		                  (i >= 1 && i <= 5 && j >= 1 && j <= 5 && vis[i - 1][j] && vis[i + 1][j] && !vis[i][j - 1] && !vis[i][j + 1]) ||

		                  (i >= 1 && i <= 5 && j >= 1 && j <= 5 && !vis[i - 1][j] && !vis[i + 1][j] && vis[i][j - 1] && vis[i][j + 1]);


		if (hitWall)return;


		


		vis[i][j] = true;

		char c=s.charAt(k);

		switch (c) {
		case 'U':
			if (i - 1 >= 0)
				solve(s, i - 1, j, k + 1);
			vis[i][j] = false;
			return;

		case 'D':
			if (i + 1 < 7)
				solve(s, i + 1, j, k + 1);
			vis[i][j] = false;
			return;

		case 'L':
			if (j - 1 >= 0)
				solve(s, i, j - 1, k + 1);
			vis[i][j] = false;
			return;

		case 'R':
			if (j + 1 < 7)
				solve(s, i, j + 1, k + 1);
			vis[i][j] = false;
			return;
		}


		if (i + dr[0] >= 0 && i + dr[0] < 7 && j + dc[0] >= 0 && j + dc[0] < 7 && !vis[i + dr[0]][j + dc[0]])
			solve(s, i + dr[0], j + dc[0], k + 1);

		if (i + dr[1] >= 0 && i + dr[1] < 7 && j + dc[1] >= 0 && j + dc[1] < 7 && !vis[i + dr[1]][j + dc[1]])
			solve(s, i + dr[1], j + dc[1], k + 1);

		if (i + dr[2] >= 0 && i + dr[2] < 7 && j + dc[2] >= 0 && j + dc[2] < 7 && !vis[i + dr[2]][j + dc[2]])
			solve(s, i + dr[2], j + dc[2], k + 1);

		if (i + dr[3] >= 0 && i + dr[3] < 7 && j + dc[3] >= 0 && j + dc[3] < 7 && !vis[i + dr[3]][j + dc[3]])
			solve(s, i + dr[3], j + dc[3], k + 1);


		vis[i][j] = false;
	}
	public int run(String s) {
		vis = new boolean[7][7];
		solve(s, 0, 0, 0);
		return paths;
		// return 0;
	}


	public static void main(String[] args) throws IOException {
		GridPathsCS o = new GridPathsCS();
		String s = br.readLine().trim();
		// printEl(c);
		op.append(o.run(s)).append("\n");
		System.out.println(op);
	}



















//<print2D>

	private static void printEl(long a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	private static void printEl(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	private static void printEl(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	private static void printEl(String a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	private static void printElN(long a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void printElN(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void printElN(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void printElN(String a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void print2D(char c[][]) {
		int n = c.length, m = c[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void print2D(int c[][]) {
		int n = c.length, m = c[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void print2D(long c[][]) {
		int n = c.length, m = c[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void print2D(double c[][]) {
		int n = c.length, m = c[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void print2D(String c[][]) {
		int n = c.length, m = c[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	//<print2D/>




	//<BinarySearch>

	//<UpperBoud>

	public static int upperBound(List<Integer>a, int k) {
		int n = a.size();
		int start = 0, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (k > a.get(mid)) {
				start = mid + 1;
			} else end = mid;
		}
		return end;
	}

	public static int upperBound(int[] a, int k) {
		int n = a.length;
		int start = 0, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (k > a[mid]) {
				start = mid + 1;
			} else end = mid;
		}
		return end;
	}

	//<UpperBoud/>

	// <inputs>

	public static int[] nextIntA(int n)throws IOException {
		int a[] = new int[n];
		st = nst(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = sToInt(st.nextToken());
		}
		return a;
	}

	//<BinarySearch/>

	//<input/>

	// string/char to number
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

	//StringTokenIzer
	public static StringTokenizer nst(String s) {
		return new StringTokenizer(s);
	}
}
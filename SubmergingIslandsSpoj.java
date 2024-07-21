import java.io.*;
import java.util.*;
public class SubmergingIslandsSpoj {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;


	public static int[] dr = { -1 , 1, 0, 0};

	public static int[] dc = {0, 0, -1, 1};













	boolean vis[];
	int hi[];
	int low[];
	int child[];
	int time = 1;
	Set<Integer>atPoints;

	public void dfs(int cur, int par, List<List<Integer>>adj) {
		vis[cur] = true;
		hi[cur] = time;
		low[cur] = time;
		time++;
		for (int x : adj.get(cur)) {
			if (!vis[x]) {
				child[cur]++;
				dfs(x, cur, adj);
				low[cur] = Math.min(low[cur], low[x]);
				if (par != 0 && low[x] >= hi[cur]) {
					// op.append(hlo).append("\n");
					atPoints.add(cur);
				}
			} else if (par != x) {
				low[cur] = Math.min(low[cur], hi[x]);
			}

		}
		if (par == 0 && child[cur] > 1)atPoints.add(cur);

	}

	public int run() {
		return 0;
	}

	public int f() {
		return 0;
	}
















	public static void main(String[] args) throws IOException {

		while (true) {
			SubmergingIslandsSpoj o = new SubmergingIslandsSpoj();
			st = nst(br.readLine());
			int n = sToInt(st.nextToken()), m = sToInt(st.nextToken());
			if(n==0 && m==0)break;
			List<List<Integer>>edges = new ArrayList<>();
			List<List<Integer>>adj = new ArrayList<>();
			o.atPoints = new HashSet<>();
			o.vis = new boolean[n + 1];
			o.hi = new int[n + 1];
			o.low = new int[n + 1];
			o.child = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				adj.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				edges.add(nextIntL(2));
				adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
				adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
			}
			o.dfs(1, 0, adj);
			op.append(o.atPoints.size()).append("\n");
			// op.append(o.atPoints + " " + Arrays.toString(o.child) + " " + Arrays.toString(o.hi) + " " + Arrays.toString(o.low)).append("\n");
		}

		pw.println(op);
		pw.flush();

	}










































































//<print2D>

	public static int getNode2D(int row, int col, int n, int m) {
		return (row) * (m) + col;
	}


	public static void printEl(long a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	public static void printEl(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	public static void printEl(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	public static void printEl(String a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}
	}

	public static void printElN(long a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void printElN(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void printElN(char a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void printElN(String a[]) {
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


	public static int lowerBound(int[] a, int k, int i, int j) {
		int n = a.length;
		int start = i, end = j;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (k <= a[mid]) {
				end = mid;
			} else start = mid + 1;
		}
		return end;
	}



	public static int upperBound(int[] a, int k, int i, int j) {
		int n = a.length;
		int start = i, end = j;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (k >= a[mid]) {
				start = mid + 1;
			} else end = mid;
		}
		return end;
	}


	// <Lower Bound>


	public static int lowerBound(int[] a, int k) {
		int n = a.length;
		int start = 0, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (k <= a[mid]) {
				end = mid;
			} else start = mid + 1;
		}
		return end;
	}

	public static int lowerBound(List<Integer>a, int k) {
		int n = a.size();
		int start = 0, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (k <= a.get(mid)) {
				end = mid;
			} else start = mid + 1;
		}
		return end;
	}






	//<UpperBoud>

	public static int upperBound(List<Integer>a, int k) {
		int n = a.size();
		int start = 0, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (k >= a.get(mid)) {
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
			if (k >= a[mid]) {
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

	public static List<Integer> nextIntL(int n)throws IOException {
		List<Integer>a = new ArrayList<>();
		st = nst(br.readLine());
		for (int i = 0; i < n; i++) {
			a.add(sToInt(st.nextToken()));
		}
		return a;
	}

	public static long[] nextLongA(int n)throws IOException {
		long a[] = new long[n];
		st = nst(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = sToLong(st.nextToken());
		}
		return a;
	}

	public static List<Long> nextLongL(int n)throws IOException {
		List<Long>a = new ArrayList<>();
		st = nst(br.readLine());
		for (int i = 0; i < n; i++) {
			a.add(sToLong(st.nextToken()));
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
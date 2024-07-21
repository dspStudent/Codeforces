import java.io.*;
import java.util.*;
public class TheOmnipotentMonsterKiller {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;


	public static int[] dr = { -1 , 1, 0, 0};

	public static int[] dc = {0, 0, -1, 1};















	public long solve(List<long[]>edges, int n, List<Long>a) {
		List<List<Long>>adj = new ArrayList<>();
		for (int i = 0; i <= n; i++)adj.add(new ArrayList<>());
		for (long i[] : edges) {
			adj.get((int)i[0]).add(i[1]);
			adj.get((int)i[1]).add(i[0]);
		}
		List<Long>bfs = bFS(adj, a);
		// for (int i = 0; i < bfs.size(); i++)op.append(bfs.get(i)).append("\n");
		long sum = a.stream().mapToLong(i->i).sum();
		long oSum = 0L, eSum = 0;
		for (int i = 0; i < bfs.size(); i++) {
			if (i % 2 == 0)eSum += bfs.get(i);
			else oSum += bfs.get(i);
		}
		long o=(long)sum + (long)sum - (long)eSum, e=(long)sum+ (long)sum - (long)oSum;
		return Math.min(o, e);
	}

	public List<Long> bFS(List<List<Long>> adj, List<Long>a) {
		Queue<Long>q = new LinkedList<>();
		List<Long>bfs = new ArrayList<>();
		boolean vis[] = new boolean[adj.size()];
		q.add(1L);
		bfs.add(a.get(1));
		while (!q.isEmpty()) {
			long levls = 0L;
			long qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				long x = q.poll();
				vis[(int)x] = true;
				for (long node : adj.get((int)x)) {
					if (vis[(int)node])continue;
					levls += a.get((int)node);
					q.add(node);
				}
			}

			bfs.add(levls);
		}
		return bfs;
	}

	public int f() {
		return 0;
	}














	public static void main(String[] args) throws IOException {
		TheOmnipotentMonsterKiller o = new TheOmnipotentMonsterKiller();
		int t = sToInt(br.readLine());
		while (t-- > 0) {
			int n = sToInt(br.readLine());
			List<Long>a = nextLongL(n + 1);
			List<long[]>edges = new ArrayList<>();
			for (int i = 0; i < n - 1; i++) {
				st = nst(br.readLine());
				edges.add(new long[] {sToLong(st.nextToken()), sToLong(st.nextToken())});
			}
			// op.append(a).append("\n");
			op.append(o.solve(edges, n, a)).append("\n");

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
			if (i == 0) {
				a.add(0L);
				continue;
			}
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
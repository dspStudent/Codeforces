import java.io.*;
import java.util.*;
public class MaximumConnectedGroupAtmost1 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;


	public static int[] dr = { -1 , 1, 0, 0};

	public static int[] dc = {0, 0, -1, 1};


	public int maxConnection(int grid[][]) {

		int n = grid.length, m = grid[0].length;
		DisjointSetUnion dsu = new DisjointSetUnion(n * m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
		// int i=0, j=0;
				if (grid[i][j] == 1) {
					int nodeX = getNode2D(i, j, n, m);
					// left
					if(j-1>=0 && grid[i][j-1]==1){
						// System.out.println("left");
						int node=getNode2D(i, j-1, n, m);
						dsu.addUniBySize(nodeX, node);
					}

					// right
					if(j+1<m && grid[i][j+1]==1){
						// System.out.println("right");
						int node=getNode2D(i, j+1, n, m);
						dsu.addUniBySize(nodeX, node);
					}

					// up
					if(i-1>=0 && grid[i-1][j]==1){
						// System.out.println("up");
						int node=getNode2D(i-1, j, n, m);
						dsu.addUniBySize(nodeX, node);
					}

					// bottom
					if(i+1<n && grid[i+1][j]==1){
						// System.out.println("bottom");
						int node=getNode2D(i+1, j, n, m);
						dsu.addUniBySize(nodeX, node);
					}

				}
			}
		}

		System.out.println(Arrays.toString(dsu.dsu));
		System.out.println(Arrays.toString(dsu.size));
		return 0;


	}

	public static void main(String[] args) throws IOException {
		MaximumConnectedGroupAtmost1 o = new MaximumConnectedGroupAtmost1();
		int t = sToInt(br.readLine());
		while (t-- > 0) {
			st = nst(br.readLine());
			int n = sToInt(st.nextToken());
			int m = sToInt(st.nextToken());
			int a[][] = new int[n][m];
			for (int i = 0; i < n; i++)a[i] = nextIntA(m);
			op.append(o.maxConnection(a)).append("\n");
		}
		System.out.println(op);
	}
























	//<print2D>

	public static int getNode2D(int row, int col, int n, int m) {
		// System.out.println(m);
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
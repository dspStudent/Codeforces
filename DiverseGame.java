import java.io.*;
import java.util.*;
public class DiverseGame {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;


	public static int[] dr = { -1 , 1, 0, 0};

	public static int[] dc = {0, 0, -1, 1};















	public void solve1(int a[][]) {
		int n = a.length, m = a[0].length;
		int tot = n * m;
		HashSet<Integer>set1 = new HashSet<>();
		int b[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				b[i][j] = -1;
				A:
				for (int k = 1; k <= m * n; k++) {
					if (a[i][j] != k && !set1.contains(k)) {
						b[i][j] = k;
						set1.add(k);
						break A;
					}
				}
				if (b[i][j] == -1) {
					op.append(-1).append("\n");
					return;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				op.append(b[i][j] + " ");
			}
			if (i != n - 1)
				op.append("\n");
		}
		op.append("\n");
		return ;
	}


	public int f() {
		return 0;
	}


	Set<Integer>set = new HashSet<>();

	public boolean run(int a[][], int b[][], int r, int c) {
		int n = a.length, m = a[0].length;
		
				b[r][c] = -1;
				for (int k = 1; k < m * n; k++) {
					if (a[r][c] != k && !set.contains(k)) {
						set.add(k);
						b[r][c] = k;
						int nr=c==m-1?r+1:r, nc=c==m-1?0:c+1;
						if(run(a, b, nr, nc))
						break;
						else{
							set.remove(b[r][c]);b[r][c]=-1;
						}
					}
				}
				if(b[r][c]==-1){
					return false;
				
		}
		return true;
	}


	public void solve(int a[][]) {
		int n = a.length, m = a[0].length;
		if(n==1 && m==1){
			op.append(-1).append("\n");
			return;
		}
		if(m==1){
			for(int i=0;i<n;i++){
				op.append(a[(i+(n-1))%n][0]).append("\n");
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				op.append(a[i][(j+m-1)%m] + " ");
			}
			if (i != n - 1)
				op.append("\n");
		}
		op.append("\n");
	}








	public static void main(String[] args) throws IOException {
		DiverseGame o = new DiverseGame();
		int t = sToInt(br.readLine());
		while (t-- > 0) {
			st = nst(br.readLine());
			int n = sToInt(st.nextToken()), m = sToInt(st.nextToken());
			int a[][] = new int[n][m];
			for (int i = 0; i < n; i++)a[i] = nextIntA(m);
			// print2D(a);
			o.solve(a);
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
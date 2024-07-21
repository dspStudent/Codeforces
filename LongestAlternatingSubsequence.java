import java.io.*;
import java.util.*;
public class LongestAlternatingSubsequence {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;


	public static int[] dr = { -1 , 1, 0, 0};

	public static int[] dc = {0, 0, -1, 1};




	public int[] leftMin(int a[]) {
		int n = a.length;
		int leftMin[] = new int[n];
		leftMin[0] = -1;
		int i = 0;
		Stack<Integer>st = new Stack<>();
		st.push(0);
		while (i < n) {
			while (!st.isEmpty() && a[st.peek()] >= a[i])st.pop();
			if (st.isEmpty())leftMin[i] = -1;
			else leftMin[i] = st.peek();
			st.push(i);
			i++;
		}
		return leftMin;
	}
	public int[] rightMin(int a[]) {
		int n = a.length;
		int rightMin[] = new int[n];
		rightMin[n - 1] = -1;
		int i = n - 2;
		Stack<Integer>st = new Stack<>();
		st.push(n - 1);
		while (i >= 0) {
			while (!st.isEmpty() && a[st.peek()] >= a[i])st.pop();
			if (st.isEmpty())rightMin[i] = -1;
			else rightMin[i] = st.peek();
			st.push(i);
			i--;
		}
		return rightMin;
	}
	public int[] leftMax(int a[]) {
		int n = a.length;
		int leftMax[] = new int[n];
		leftMax[0] = -1;
		int i = 0;
		Stack<Integer>st = new Stack<>();
		st.push(0);
		while (i < n) {
			while (!st.isEmpty() && a[st.peek()] <= a[i])st.pop();
			if (st.isEmpty())leftMax[i] = -1;
			else leftMax[i] = st.peek();
			st.push(i);
			i++;
		}
		return leftMax;
	}
	public int[] rightMax(int a[]) {
		int n = a.length;
		int rightMax[] = new int[n];
		rightMax[n - 1] = -1;
		int i = n - 2;
		Stack<Integer>st = new Stack<>();
		st.push(n - 1);
		while (i >= 0) {
			while (!st.isEmpty() && a[st.peek()] <= a[i])st.pop();
			if (st.isEmpty())rightMax[i] = -1;
			else rightMax[i] = st.peek();
			st.push(i);
			i--;
		}
		return rightMax;
	}










	public int alternatingMaxLength1(int a[]) {
		int rightMi[] = rightMin(a);
		int rightMa[] = rightMax(a);
		// for (int i = 0; i < a.length; i++)al[i] = a[i];
		// System.out.println(Arrays.toString(rightMa));
		// System.out.println(Arrays.toString(rightMi));
		
		int n = a.length, ans = 0;
		for (int i = 0; i < n; i++) {
			int max = max(a, i, rightMi, rightMa);
			int min = min(a, i, rightMi, rightMa);
			// op.append(max + " " + min).append("\n");
			ans = Math.max(ans, Math.max(max, min));
		}
		return ans;
	}




	public int max(int a[], int index, int[]rightMi, int []rightMa) {

		int count = 0;
		int i = index, n = a.length;
		int rightSmall = -1, rightBig = -1;
		boolean turn = true;
		while (i < n) {
			count++;
			if (turn) {
				int rm = rightMa[i];
				if (rm == -1|| rm==i)return count;
				i = rm;
				
				turn = false;
			} else {
				int rm = rightMi[i];
				if (rm == -1|| rm==i)return count;
				i = rm;
				
				turn = true;
			}
		}
		return count++;
	}

	public int min(int a[], int index, int[]rightMi, int []rightMa) {

		int count = 0;
		int i = index, n = a.length;
		
		boolean turn = false;
		while (i < n) {
			count++;
			if (turn) {
				int rm = rightMa[i];
				
				if (rm == -1 || rm==i)return count;
				i = rm;
				
				turn = false;
			} else {
				int rm = rightMi[i];
				// op.append(rm+" "+i+" "+index).append("\n");
				if (rm == -1 || rm==i)return count;
				i = rm;
				
				turn = true;
			}
		}
		return count++;
	}



	public int alternatingMaxLength(int a[]){
		int up=1, down=1, n=a.length;
		for(int i=1;i<n;i++){
			if(a[i-1]>a[i]){
				down=up+1;
			}
			if(a[i-1]<a[i]){
				up=down+1;
			}
		}
		return Math.max(up, down);
	}











	public static void main(String[] args) throws IOException {
		LongestAlternatingSubsequence o = new LongestAlternatingSubsequence();
		int t = sToInt(br.readLine());
		while (t-- > 0) {
			int n = sToInt(br.readLine());
			int a[] = nextIntA(n);
			op.append(o.alternatingMaxLength(a)).append("\n");
			// op.append("hello").append("\n");
		}
		pw.println(op);
		pw.flush();
	}














	// 1 2 3 3 4 5 2 4 10 11

	// 1 2 3 4 5 6 7 8 9  10























































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
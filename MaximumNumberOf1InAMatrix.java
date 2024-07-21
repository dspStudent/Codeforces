import java.io.*;
import java.util.*;
public class MaximumNumberOf1InAMatrix {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;

	public static int[] leftMin(int a[]) {
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
	public  static int[] rightMin(int a[]) {
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
	public static int[] leftMax(int a[]) {
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
	public static int[] rightMax(int a[]) {
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


	public int solve(int a[]){
		int leftSmall[]=leftMin(a);
		int rightSmall[]=rightMin(a);
		System.out.println(" left "+Arrays.toString(leftSmall));
		System.out.println(" right "+Arrays.toString(rightSmall));
		System.out.println();
		int max=Integer.MIN_VALUE, ans=0;
		for(int i=0;i<a.length;i++){
			int leftIndex=leftSmall[i]+1;
			int rightIndex=rightSmall[i]-1;
			if(a[i]*(rightIndex-leftIndex+1)> max){
				max=a[i]*(rightIndex-leftIndex+1);
				ans=Math.max(a[i], rightIndex-leftIndex+1);
			}
		}
		return ans;
	}




	public int maxSquare(int n, int m, int mat[][]) {
		int a[]=new int[m];
		int max=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j]==0)a[j]=0;
				else a[j]=a[j]+1;
			}
			max=Math.max(max, solve(a));
		}
		return max;
	}
	

	public static void main(String[] args) throws IOException {
		MaximumNumberOf1InAMatrix o = new MaximumNumberOf1InAMatrix();
		int t = sToInt(br.readLine());
		while (t-- > 0) {
			st = nst(br.readLine());
			int n = sToInt(st.nextToken()), m = sToInt(st.nextToken());
			int a[][] = new int[n][m];
			for (int i = 0; i < n; i++)a[i] = nextIntA(m);
			op.append(o.maxSquare(n, m, a)).append("\n");
		}
		System.out.println(op);
	}























	//<print2D>

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
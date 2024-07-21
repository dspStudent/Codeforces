import java.io.*;
import java.util.*;
public class DigitQueries {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;

	private static long mathPow(long a, int b) {
		long res = 1L;
		while (b != 0) {
			if ((b & 1) == 1)res = (res * a);
			a = (a * a);
			b >>= 1;
		}
		return res;
	}

	private long solve(long k, long []numDig, long []startNum, long []prefSum) {

		long rem=k;
		int index=0;
		for(int i=1;i<18;i++){
			if(rem-numDig[i]<0){
				index=i;
				break;
			}
			rem-=numDig[i];
		}
		// op.append("rem "+rem).append("\n");
		// op.append("index "+index).append("\n");
		long exactRemNum=rem/index;

		// op.append("exactRemNum "+exactRemNum).append("\n");

		// 1 2 3 4 5 6 7 8 9|   1   0  1  1  1 
		// 1 2 3 4 5 6 7 8 9|   10 11 12 13 14

		long exactNum=startNum[index]+exactRemNum-1;

		// op.append("exactNum "+exactNum).append("\n");

		// op.append("mod "+rem%index).append("\n");

		if(rem%index==0)return exactNum%10;

		long modRem=rem%index;

		exactNum+=1;

		// op.append("exactNum+1 "+exactNum).append("\n");
		return (exactNum/mathPow(10,index-(int)modRem))%10;

	}


	public static void main(String[] args) throws IOException {
		DigitQueries o = new DigitQueries();


		long numDig[] = new long[18];
		long startNum[] =new long[18];
		long prefSum[]=new long[18];
		for (int i = 1; i < 18; i++) {
			numDig[i] = i * (mathPow(10, i) - mathPow(10, i - 1));
			prefSum[i]=numDig[i];
		}

		for (int i=1;i<18;i++) {
			prefSum[i]+=prefSum[i-1];
			startNum[i]=mathPow(10, i-1);			
		}
		// System.out.println("numDig ");
		// printEl(numDig);
		// System.out.println("prefSum ");
		// printEl(prefSum);
		// System.out.println("startNum ");
		// printEl(startNum);
		int q = sToInt(br.readLine());
		while (q-- > 0) {
			long k = sToLong(br.readLine());
			op.append(o.solve(k, numDig, startNum, prefSum)).append("\n");
		}
		System.out.println(op);
	}























	//<print2D>

	private static void printEl(long a[]){
	   for(int i=0;i<a.length;i++){
	   	System.out.println(i+" "+a[i]);
	   }
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
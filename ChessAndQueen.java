import java.io.*;
import java.util.*;
public class ChessAndQueen {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;


	int count = 0;
	private boolean solve(char c[][], int row, int col) {
		for (int i = 0; i < 8; i++) {
			if (c[row][i] == 'q')return false;
			if (c[i][col] == 'q')return false;
			// if(c[(row+i)%8][(col+i)%8]=='q')return false;
		}


		int r=row, co=col;
		while(r<8 && co<8){
			if(c[r][co]=='q')return false;
			r++;co++;
		}
		r=row;co=col;

		while(r>=0 && co>=0){
			if(c[r][co]=='q')return false;
			r--;co--;
		}

		r=row;co=col;
		while(r>=0 && co<8){
			if(c[r][co]=='q')return false;
			r--;co++;
		}
		r=row; co=col;
		while(r<8 && co>=0){
			if(c[r][co]=='q')return false;
			r++;co--;
		}
		return true;
	}

	public void run(char c[][], int n) {
		if (n == 8){
			count++;
			return ;
		}
		for(int i=0;i<8;i++){
			if(c[n][i]=='*')continue;
			boolean isItPossible=solve(c, n, i);
			if(isItPossible==false)continue;
			c[n][i]='q';
			run(c, n+1);
			c[n][i]='.';
		}

	}


	public static void main(String[] args) throws IOException {
		ChessAndQueen o = new ChessAndQueen();
		char c[][] = new char[8][8];
		for (int i = 0; i < 8; i++) {
			c[i] = br.readLine().trim().toCharArray();
		}
		o.run(c, 0);
		System.out.println(o.count);
		System.out.println(op);
	}
















    //<print2D>

	public static void print2D(char c[][]){
		int n=c.length, m=c[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void print2D(int c[][]){
		int n=c.length, m=c[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void print2D(long c[][]){
		int n=c.length, m=c[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void print2D(double c[][]){
		int n=c.length, m=c[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void print2D(String c[][]){
		int n=c.length, m=c[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(c[i][j]+" ");
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
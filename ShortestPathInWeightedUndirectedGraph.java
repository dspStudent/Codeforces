import java.io.*;
import java.util.*;
public class ShortestPathInWeightedUndirectedGraph {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;


	public static int[] dr = { -1 , 1, 0, 0};

	public static int[] dc = {0, 0, -1, 1};















	public int solve() {
		return 0;
	}

	public int run() {
		return 0;
	}

	public int f() {
		return 0;
	}


	public List<Integer> shortestPath(int n, int m, int edges[][]) {

		List<ArrayList<int[]>>adj = getAdjListWithWeight(edges, n+1);
		List<Integer>ans=new ArrayList<>();
		boolean vis[]=new boolean[n+1];
		int di[]=new int[n+1];
		Arrays.fill(di, Integer.MAX_VALUE);
		PriorityQueue<int[]> q = new PriorityQueue<>((i, j)->i[1]-j[1]);
		q.add(new int[]{1, 0});

		while(!q.isEmpty()){
			int poll[]=q.poll();
			int node=poll[0], dis=poll[1];
			// op.append(node+" "+dis).append("\n");
			if(vis[node])continue;
			vis[node]=true;
			for(int i[]:adj.get(node)){
				if(dis+i[1] < di[i[0]]){
					di[i[0]]=dis+i[1];
					q.add(new int[]{i[0], di[i[0]]});
				}
			}
		}
		return di[n]==Integer.MAX_VALUE?new ArrayList<>(List.of(-1)):new ArrayList<>(List.of(di[n]));
		// System.out.println(Arrays.toString(di));
		// return di[n];
        	
    }











	public static void main(String[] args) throws IOException {
		ShortestPathInWeightedUndirectedGraph o = new ShortestPathInWeightedUndirectedGraph();
		int t = sToInt(br.readLine());
		while (t-- > 0) {
			st = nst(br.readLine());
			int n = sToInt(st.nextToken()), m = sToInt(st.nextToken());
			int [][]edges = new int[m][3];
			for (int i = 0; i < m; i++) {
				edges[i] = nextIntA(3);
			}
			
			op.append(o.shortestPath(n, m, edges)).append("\n");
		}
		System.out.println(op);
	}



















	// <graph>


	public static List<ArrayList<int[]>> getAdjListWithWeight(int edges[][], int n) {
		List<ArrayList<int[]>> adj = new ArrayList();
		for (int i = 0; i < n; i++)adj.add(new ArrayList<>());
		for (int i[] : edges) {
			adj.get(i[0]).add(new int[] {i[1], i[2]});
			adj.get(i[1]).add(new int[] {i[0], i[2]});
		}
		return adj;
	}

	public static List<ArrayList<Integer>> getAdjList(int edges[][], int n) {
		List <ArrayList<Integer>> adj = new ArrayList();
		for (int i = 0; i < n; i++)adj.add(new ArrayList<>());
		for (int i[] : edges) {
			adj.get(i[0]).add(i[1]);
			adj.get(i[1]).add(i[0]);
		}
		return adj;
	}

	public static List<ArrayList<Integer>> getAdjListDi(int edges[][], int n) {
		List < ArrayList<Integer >> adj = new ArrayList();
		for (int i = 0; i < n; i++)adj.add(new ArrayList<>());
		for (int i[] : edges) {
			adj.get(i[0]).add(i[1]);
		}
		return adj;
	}

	public static List<ArrayList<int[]>> getAdjListDiWithWeight(int edges[][], int n) {
		List<ArrayList<int[]>>adj = new ArrayList();
		for (int i = 0; i < n; i++)adj.add(new ArrayList<>());
		for (int i[] : edges) {
			adj.get(i[0]).add(new int[] {i[1], i[2]});
		}
		return adj;
	}




	// <graph/>

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
			a[i] = sToInt(st.nextToken()) ;
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
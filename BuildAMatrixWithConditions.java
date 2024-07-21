import java.io.*;
import java.util.*;
public class BuildAMatrixWithConditions {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;

    
    public static int[] dr={-1 , 1, 0, 0};

    public static int[] dc={0, 0, -1, 1};















    public int solve(){
        return 0;
    }

    public int run(){
        return 0;
    }

    public int f(){
        return 0;
    }

    
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>[] rowGraph = new ArrayList[k + 1]; 
        for(int i = 1 ; i < rowGraph.length; i ++) {
            rowGraph[i] = new ArrayList();
        }
        for(int [] rowCondition : rowConditions){ 
            rowGraph[rowCondition[0]].add(rowCondition[1]); 
        }

        List<Integer>[] colGraph = new ArrayList[k + 1]; 
        for(int i = 1 ; i < colGraph.length; i ++) {
            colGraph[i] = new ArrayList();
        }
        for(int [] colCondition : colConditions){
            colGraph[colCondition[0]].add(colCondition[1]); 
        }

        int[] visited = new int[k + 1];
        Deque<Integer> queue = new LinkedList<>(); 
        for(int i = 1; i < rowGraph.length; i++){ 
            if(!topSort(rowGraph, i, visited, queue)){
                return new int[0][0];
            }
        }

        
        int[] rowIndexMap = new int[k + 1]; 
        for(int i = 0; i < k; i++){ 
            int node = queue.pollLast(); 
            rowIndexMap[node] = i;
        }

        visited = new int[k + 1];
        queue = new LinkedList();
        for(int i = 1; i < colGraph.length; i++){
            if(!topSort(colGraph, i, visited, queue)){
                return new int[0][0];
            }
        }

        int[] colOrder = new int[k];
        int[] colIndexMap = new int[k+1];
        for(int i = 0; i < k; i++){
            int node = queue.pollLast();
            colOrder[i] = node;
            colIndexMap[node] = i;
        }

        int[][] result = new int[k][k];
        
        for(int i = 1; i <= k; i++){
            result[rowIndexMap[i]][colIndexMap[i]] = i;
        }

        return result;

    }

    public boolean topSort(List<Integer>[] graph, int node, int[] visited, Deque<Integer> queue){
        if(visited[node] == 2) {
            return false;
        }
        if(visited[node] == 0){
            visited[node] = 2;
            for(int child : graph[node]){
                if(!topSort(graph, child, visited, queue)){
                    return false;
                }
            }
            visited[node] = 1;
            queue.add(node);
        }
        return true;
    }

















    public static void main(String[] args) throws IOException{ 
        BuildAMatrixWithConditions o=new BuildAMatrixWithConditions();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
        	int k=sToInt(br.readLine());
            st=nst(br.readLine());
            int n1=sToInt(st.nextToken()), m1=sToInt(st.nextToken());
            int r[][]=new int[n1][m1];
            for(int i=0;i<n1;i++)r[i]=nextIntA(m1);

            st=nst(br.readLine());
            n1=sToInt(st.nextToken());
            m1=sToInt(st.nextToken());
            int c[][]=new int[n1][m1];
            for(int i=0;i<n1;i++)c[i]=nextIntA(m1);
            int a[][]=o.buildMatrix(k, r, c);
            print2D(a);
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
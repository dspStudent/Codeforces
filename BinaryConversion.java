import java.io.*;
import java.util.*;
public class BinaryConversion {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;

    
    public static int[] dr={-1 , 1, 0, 0};

    public static int[] dc={0, 0, -1, 1};















    public void solve(char from[], char to[], int m){
    	int n=from.length;
    	int one=0, zero=0, def=0;
    	for(int i=0;i<n;i++){
    		if(from[i]!=to[i])def++;
    		if(from[i]=='1')one++;
    		else zero++;
    	}
    	int o=one, z=zero;
    	for(int i=0;i<n;i++){
    		if(to[i]=='1')one--;
    		else zero--;
    	}
    	if(zero!=0 || one!=0){
    		op.append("No").append("\n");
    		return;
    	}
    	
    	int swaps=def/2;
    	if((swaps<=m && (o>=2 || z>=2)) || (swaps%2==m%2 && swaps<=m)){
    		op.append("Yes").append("\n");
    		return;
    	}
    	op.append("No").append("\n");
        return ;
    }

    public int run(){
        return 0;
    }

    public int f(){
        return 0;
    }


   // 1 1 1 1 0 1 0 0 1
   // 0 0 0 1 1 1 1 1 1

   // 1 2 3 4 5 7 8 9
   // 1 1 1 1 0 0 0 0

   // 1-5
   // 2-7
   // 3-8
   // 4-9

    //  








    public static void main(String[] args) throws IOException{ 
        BinaryConversion o=new BinaryConversion();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
        	st=nst(br.readLine());
            int n=sToInt(st.nextToken()), m=sToInt(st.nextToken());
            char from[]=br.readLine().toCharArray();
            char to[]=br.readLine().toCharArray();
            o.solve(from, to, m);
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
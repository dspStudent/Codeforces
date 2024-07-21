import java.io.*;
import java.util.*;
public class ApartmentsCsese {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder op = new StringBuilder();

    public static StringTokenizer st;



    public int solve (List<Integer>a, List<Integer> b, int k) {
        Collections.sort(a);
        Collections.sort(b);
        int i=0, j=0,  n=a.size(), m=b.size(), count=0;
        while(i<n && j<m){
            if(Math.abs(a.get(i)-b.get(j))<=k){
                count++;i++;j++;
            }
            else if(a.get(i)>b.get(j)){
                j++;
            }
            else{
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        ApartmentsCsese o = new ApartmentsCsese();
        st = nst(br.readLine());
        int nu = sToInt(st.nextToken()), na = sToInt(st.nextToken()), dif = sToInt(st.nextToken());
        List<Integer>a=nextIntL(nu);
        List<Integer>b = nextIntL(na);
        op.append(o.solve(a, b, dif)).append("\n");
        // System.out.println();
        System.out.println(op);
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
import java.io.*;
import java.util.*;
public class MinimumCosttoConvertStringI {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;

    
    public static int[] dr={-1 , 1, 0, 0};

    public static int[] dc={0, 0, -1, 1};






    boolean yes=false;








    public long solve1(int i, StringBuilder s1, StringBuilder s2, char[] from, char[] to, int[] a, Map<Character, List<Pair>>map, Set<Character>set){
    	if(yes)return 0;
    	if(i>=s1.length())return 0;
    	if(s1.charAt(i)==s2.charAt(i)){
    		set.clear();
    		return solve(i+1, s1, s2, from, to, a, map, set);
    	}
    	char c=s1.charAt(i);
    	if(set.contains(c))return 0;
    	set.add(c);
    	long min=Long.MAX_VALUE;
    	try{
    	for(Pair p:map.get(c)){
    		char ch=p.ch;
    		int co=p.co;
    		s1.setCharAt(i, ch);
    		long m=solve(i, s1, s2, from, to, a, map, set);
    		// op.append(m+" "+i).append("\n");
    		min=co+Math.min(min, m);
    		s1.setCharAt(i, c);
    	}
    }
    catch(java.lang.NullPointerException e){
    	yes=true;
    	return 0;
    }
    	// op.append(min+" "+i).append("\n");
        return min;
    }

    public int run(){
        return 0;
    }

    public int f(){
        return 0;
    }

    class Pair{
        char ch;
        int co;
        Pair(char ch, int co){
            this.ch=ch;this.co=co;
        }
        public  String toString(){
        	return this.ch+" "+this.co;
        }
    }
    public long minimumCost1(String s1, String s2, char[] from, char[] to, int[] a) {
        Map<Character, List<Pair>>map=new HashMap<>();
        for(char c:from){
        	map.put(c, new ArrayList<>());
        }
        int n=from.length;
        // op.append(n).append("\n");
        for(int i=0;i<n;i++){
        	char c1=from[i], c2=to[i];
        	map.get(c1).add(new Pair(c2, a[i]));
        }
        // return 0;
        long ans= solve(0, new StringBuilder(s1), new StringBuilder(s2), from, to, a, map, new HashSet<>());
        if(yes)return -1;
        return ans;
    }


    
    
    
    


    	






















    public static void main(String[] args) throws IOException{ 
        MinimumCosttoConvertStringI o=new MinimumCosttoConvertStringI();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
        	String s1=br.readLine().trim();
        	String s2=br.readLine().trim();
        	char from[]=br.readLine().trim().toCharArray();
        	char to[]=br.readLine().trim().toCharArray();
        	int n=sToInt(br.readLine());
        	int a[]=nextIntA(n);
            op.append(o.minimumCost(s1, s2, from, to, a)).append("\n");
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
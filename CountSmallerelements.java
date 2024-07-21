import java.io.*;
import java.util.*;
public class CountSmallerelements {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));


    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;

    
    public static int[] dr={-1 , 1, 0, 0};

    public static int[] dc={0, 0, -1, 1};



    Map<A, Integer>map;

    class A{
    	int el;
    	int ind;
    	A(int el, int ind){
    		this.el=el;
    		this.ind=ind;
    	}
    	public  String toString(){
    		return this.el+" "+this.ind;
    	}
    }


    int[] constructLowerArray(int[] arr) {
        map=new HashMap<>();

        int n=arr.length;
        // int arr[]=new int[n];
        A a[]=new A[n];
        for(int i=0;i<n;i++){
        	a[i]=new A(arr[i], i);
        }
        mergeSort(a, 0, n-1);
        int ans[]=new int[n];
        // op.append(map).append("\n");
        for(A i:map.keySet()){
        	ans[i.ind]=map.getOrDefault(i, 0);
        }
        // op.append(map).append("\n");
        return ans;
    }











    public void mergeSort(A a[], int start, int end){
    	if(start>=end)return;
    	int mid=start+(end -start)/2;
    	mergeSort(a, start, mid);
    	mergeSort(a, mid+1, end);
    	a=run(a, start, mid, end);
        return ;
    }

    public A[] run(A a[], int start , int mid, int end){
    	int l=start, r=end;
    	A b[]=new A[end-start+1];
    	int i=start, j=mid+1, k=0;
    	while(i<=mid && j<=end){
    		if(a[i].el>a[j].el){
    			map.put(a[i], map.getOrDefault(a[i], 0)+end-j+1);
    			// op.append(map+" "+start+" "+end).append("\n");
    			b[k]=a[i];
    			i++;
    		}
    		else{
    			// map.put(a[j], map.getOrDefault(a[j], 0)+mid-i+1);
    			b[k]=a[j];
    			j++;
    		}
    		k++;
    	}
    	while(i<=mid){
    		b[k++]=a[i++];
    	}
    	while(j<=end){
    		b[k++]=a[j++];
    	}
    	for(int s=start, it=0;s<=end;s++, it++){
    		// b[it]=a[s];
    		a[s]=b[it];
    	}
        return a;
    }


    public int f(){
        return 0;
    }












    public static void main(String[] args) throws IOException{ 
        CountSmallerelements o=new CountSmallerelements();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
        	int n=sToInt(br.readLine());
        	int a[]=nextIntA(n);
            op.append(Arrays.toString(o.constructLowerArray(a))).append("\n");
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
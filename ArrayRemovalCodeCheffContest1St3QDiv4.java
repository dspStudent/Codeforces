import java.io.*;
import java.util.*;
class ArrayRemovalCodeCheffContest1St3QDiv4 {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;

    
    public static int[] dr={-1 , 1, 0, 0};

    public static int[] dc={0, 0, -1, 1};

    public int solve(int a[]){
    	int or=0;
    	for(int i:a)or=or|i;
    	int tempOr=or;
    	int bitIndex=0;
    	while(tempOr!=0){
    		if((tempOr&1)==0)break;
    		bitIndex++;
    		tempOr>>=1;
    	}
    	int numToRemoved=0;
    	for(int i:a){
    		if((i>>bitIndex) !=0)numToRemoved++;
    	}
    	return numToRemoved;
    }

    public static void main(String[] args) throws IOException{ 
        ArrayRemovalCodeCheffContest1St3QDiv4 o=new ArrayRemovalCodeCheffContest1St3QDiv4();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
        	int n=sToInt(br.readLine());
            int a[]=nextIntA(n);
            op.append(o.solve(a)).append("\n");
        }
        System.out.println(op);
    }























   //<print2D>

   private static void printEl(long a[]){
       for(int i=0;i<a.length;i++){
        System.out.println(i+" "+a[i]);
       }
    }

    private static void printEl(int a[]){
       for(int i=0;i<a.length;i++){
        System.out.println(i+" "+a[i]);
       }
    }

    private static void printEl(char a[]){
       for(int i=0;i<a.length;i++){
        System.out.println(i+" "+a[i]);
       }
    }

    private static void printEl(String a[]){
       for(int i=0;i<a.length;i++){
        System.out.println(i+" "+a[i]);
       }
    }

    private static void printElN(long a[]){
       for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
       }
       System.out.println();
    }

    private static void printElN(int a[]){
        for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
       }
       System.out.println();
    }

    private static void printElN(char a[]){
        for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
       }
       System.out.println();
    }

    private static void printElN(String a[]){
        for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
       }
       System.out.println();
    }
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

    public static int upperBound(List<Integer>a, int k){
        int n=a.size();
        int start=0, end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(k>a.get(mid)){
                start=mid+1;
            }
            else end=mid;
        }
        return end;
    }

    public static int upperBound(int[] a, int k){
        int n=a.length;
        int start=0, end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(k>a[mid]){
                start=mid+1;
            }
            else end=mid;
        }
        return end;
    }

    //<UpperBoud/>

    // <inputs> 

    public static int[] nextIntA(int n)throws IOException{
        int a[]=new int[n];
        st=nst(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=sToInt(st.nextToken());
        }
        return a;
    }

    //<BinarySearch/>

    //<input/>

    // string/char to number
    public static int sToInt(String s){
        return Integer.parseInt(s);
    }
    public static long sToLong(String s){
        return Long.parseLong(s);
    }
    public static int sToInt(char c){
        return Integer.parseInt(c+"");
    }
    public static long sToLong(char c){
        return Long.parseLong(c+"");
    }

    //StringTokenIzer
    public static StringTokenizer nst(String s){
        return new StringTokenizer(s);
    }

}
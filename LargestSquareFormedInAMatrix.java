import java.io.*;
import java.util.*;
public class LargestSquareFormedInAMatrix {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;




    static int dp[][];
    static int max=Integer.MIN_VALUE;

    static int solve(int i, int j, int [][]mat){
    	if(i>=mat.length || j>=mat[0].length)
    		return 0;
    	if(dp[i][j]!=-1)return dp[i][j];
    	int right=solve(i, j+1, mat);
    	int daigonal=solve(i+1, j+1, mat);
    	int bottom=solve(i+1, j, mat);
    	if(mat[i][j]==0)return 0;
    	int ans= 1+Math.min(right, Math.min(daigonal, bottom));
    	max=Math.max(max, ans);
    	// op.append(max).append("\n");
    	return dp[i][j]=ans;
    }


    static int maxSquare(int n, int m, int mat[][]){
    	dp=new int[n][m];
    	for(int i[]:dp)Arrays.fill(i, -1);
		solve(0, 0, mat);
    	return max;
    }

    public static void main(String[] args) throws IOException{ 
        LargestSquareFormedInAMatrix o=new LargestSquareFormedInAMatrix();
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
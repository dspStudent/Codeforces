	import java.util.*;

	public class LongestNonDecreasingSubsequenceXOR {

		static StringBuilder sb=new StringBuilder();
		static String en="\n";

		int dp[][][];

		int f(int a[], int i, int xors, int prev, int m){
			
			if(i>=a.length){
				if(xors>=m){
					return 0;
				}
				return Integer.MAX_VALUE;
			}

			if(dp[i][xors][prev]!=-1)return dp[i][xors][prev];


			if(a[i]>=prev){
				return dp[i][xors][prev]=1+f(a, i+1, xors^a[i], a[i], m);
			}

			return dp[i][xors][prev]=f(a, i+1, xors, prev, m);
		}

		int solve(int a[], int n, int xor){

			int max=0;
			return solve(a, n, -1, 0, xor)
		}

	    public static void main(String[] args) {
	    	LongestNonDecreasingSubsequenceXOR ob=new LongestNonDecreasingSubsequenceXOR();

	        Scanner sc = new Scanner(System.in);

	        int n=sc.nextInt();
	        int m=sc.nextInt();
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)a[i]=sc.nextInt();

	        ob.dp=new int[n+1][1024][n+1];

	        // sb.append(Arrays.toString(a));

	        int ans=ob.solve(a, n,m);

	        sb.append(en).append(" ans ").append(ans);

	        System.out.println(sb);
	        // System.out.println(ans);

	        // System.out.println(1^3);
	        // System.out.println(2^3);
	        // System.out.println(3^3);
	        // System.out.println(4^3);


	    }
	        
	      
	}
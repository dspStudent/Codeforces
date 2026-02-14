import java.util.*;

public class BeautifulNumbers {

	int getSum(int n){
		return n*(n+1)/2;
	}

	StringBuilder solve(int a[], int n){
		StringBuilder sb=new StringBuilder();

		int pos[]=new int[n+1];

		for(int i=0;i<n;i++)pos[a[i]]=i;

		// System.out.println(Arrays.toString(pos));

		int maxPos=pos[1];
		int minPos=pos[1];
		sb.append("1");

		for(int i=2;i<=n;i++){
			// System.out.println("i "+(i-1)+" maxPos "+maxPos+" minPos "+minPos);
			maxPos= Math.max(maxPos, pos[i]);
			minPos=Math.min(minPos, pos[i]);

			if(maxPos-minPos+1==i){
				sb.append("1");
			}
			else{
				sb.append("0");
			}
		}

		return sb;


	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BeautifulNumbers o=new BeautifulNumbers();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();

            int a[]=new int[n];
            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            }
            StringBuilder sb=o.solve(a, n);

            // int ans[]=o.solve(a, n);
            // StringBuilder sb=new StringBuilder();
            // sb.append("1");
            // for(int i=2;i<n+1;i++){
            // 	sb.append(ans[i]);
            // }
            System.out.println(sb);

        }
        
        sc.close();
    }
    
}



// p = [5, 3, 6, 4, 2, 1]
// Brute : 110001
// Yours : 100001
import java.util.*;

public class InterestingRatio {
	static int sive[]=new int[(int)1e7+1];
	static{
		int n=sive.length;
		sive[0]=1;
		sive[1]=1;
		for(int i=2;i<(int)Math.sqrt(n);i++){
			// System.out.println(i+" "+sive[i]);
			if(sive[i]==0)
			for(int j=2*i;j<n;j+=i){
				sive[j]=1;
			}
		}
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        // Read the number of test cases
        int t = sc.nextInt();
        // System.out.println(Arrays.toString(sive));
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            long sum=0;
            // last=1;
            for(int i=2;i<=n;i++){
            	if(sive[i]==0)
            		sum+=n/i;
            }
            System.out.println(sum);
            
        }
        
        sc.close();
    }
    
   
}
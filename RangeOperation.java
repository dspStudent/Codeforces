import java.util.*;

public class RangeOperation {
	// char comb[][][]=new char[(int)1e7+1][(int)1e7+1][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
           	int a[]=new int[n];
           	// long pref[]=new long[n];
           	long tot=0;
           	for(int i=0;i<n;i++){
           		int x=sc.nextInt();
           		tot+=x;
           		// pref[i]=tot;
           		a[i]=2*(i+1)-x;
           	}

           	long max=Long.MIN_VALUE, sum=0;

           	int left=0, right=0, bLeft=0;

           	for(int i=0;i<n;i++){
           		
           		if(sum+a[i]<0){
           			sum=0;
           		}
           		else{
           			sum+=a[i];
           		}
           		max=Math.max(sum, max);
           	}

           	// System.out.println(max+" "+" "+pref[n-1]);

           		long ans=tot+max;

           	if(max<=0){
           		ans=tot;
           	}
          	// System.out.println(Arrays.toString(pref)+" right "+right+" bLeft "+bLeft+" max "+max);
           	System.out.println(ans);

        }
        
        sc.close();
    }
    
}
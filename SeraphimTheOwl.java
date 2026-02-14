import java.util.*;

public class SeraphimTheOwl {

	long solve(long[] a, long[] b, int n, int m){

		// long pref[]=new long[n];

		// pref[n-1]=b[n-1];
		// for(int i=n-2;i>=0;i--){
		// 	pref[i]=pref[i+1]+b[i];
		// }

		long sum=0;
		int side=0;

		for(int i=n-1;i>=m;i--){
			long s=a[i];
			int ss=0;
			if(b[i]<a[i]){
				s=b[i];
				ss=1;
			}
			side=ss;
			sum+=s;
		}

		long ns=a[m-1];
		int nSide=0;
		long sA=a[m-1];
		if(b[m-1]<a[m-1]){
			ns=b[m-1];
			nSide=1;
		}

		for(int i=m-2;i>=0 && nSide==1 ;i--){

			if(i==0){
				sA=Math.min(sA, ns+a[0]);
				break;
			}
			
	
			if(sA <= ns+a[i] && sA <= b[i]+ns){
				break;
			}
			else if( sA > ns+a[i] && b[i]+ns>= ns+a[i]){
				sA=ns+a[i];
				break;
			}else{
				sA=Math.min(sA, ns+a[i]);
				ns+=b[i];
			}

		}

		return sum+sA;
	}


    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        SeraphimTheOwl o=new SeraphimTheOwl();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

        	
        	long a[]=new long[n];

        	long b[]=new long[n];

        	for(int i=0;i<n;i++){
        		a[i]=sc.nextLong();
        	}

        	for(int i=0;i<n;i++){
        		b[i]=sc.nextLong();
        	} 

        	System.out.println(o.solve(a, b, n, m));
        }
        
        sc.close();
    }

}
import java.util.*;

public class ZeroRemainderArray {

	long solve(int []a, int n, int k){

		Map<Integer, Integer> map=new HashMap<>();

		for(int i=0;i<n;i++) {
			if(a[i]%k==0)continue;
			map.put(a[i]%k, map.getOrDefault(a[i]%k, 0)+1);
		}

		if(map.isEmpty())return 0;
		
		long maxEl=0;

		long maxTimes=0;

		for(int i: map.keySet()){
			int presentTime=map.get(i);
			if(i==0)continue;
			if(presentTime == maxTimes){
				maxEl=Math.min(maxEl, i);
			}
			if(presentTime > maxTimes){
				maxTimes=presentTime;
				maxEl=i;
			}
		}

		// System.out.println(map+ " "+maxEl+" "+maxTimes);

		return (maxTimes-1)*k + (k-(maxEl)) + 1; 

	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ZeroRemainderArray o=new ZeroRemainderArray();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            }
            System.out.println(o.solve(a, n, k));
        }
        
        sc.close();
    }
    
}
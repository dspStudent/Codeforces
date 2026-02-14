import java.util.*;

public class PrefixPermutationSums {

	String solve(long a[], int n){
		Set<Long> set=new HashSet<>();
		// if((n+1)*(n+2)/2 != a[n-1])return "Yes";
		for(int i=1;i<=n;i++)set.add((long)i);

		// Queue<Long> q=new LinkedList<>();

		Map<Long, Long> map=new HashMap<>();

		map.put(a[0], 1L);

		if(set.contains(a[0])){
			set.remove(a[0]);
		}

		for(int i=1;i<n-1;i++){
			long el=a[i]-a[i-1];
			// System.out.println(el+" "+a[i]+" "+a[i-1]);
			// if(el>n)q.add(el);
			// else if(set.contains(el))set.remove(el);
			// else{
			// 	q.add(el);
			// }
			if(set.contains(el)){
				set.remove(el);
			}
			map.put(el, map.getOrDefault(el, 0L)+1L);
		}

		if(set.size()>2)return "no";

		if(set.size()==1){
			int sum=n*(n+1)/2;
			if(a[n-2]!=sum)return "yes";
			else return "no";
		}

long setSum = set.stream().mapToLong(Long::longValue).sum();

		if(map.containsKey(setSum) && map.get(setSum)==2){
			return "yes";

		}else if(map.containsKey(setSum) && map.get(setSum)==1 && setSum> n){
			return "yes";
		}

		// System.out.println(map);
		// System.out.println(set);

		return "no";

	}

    public static void main(String[] args) {
    	PrefixPermutationSums o=new PrefixPermutationSums();
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
           	
           	long a[]=new long[n];

           	for(int i=0;i<n-1;i++){
           		a[i]=sc.nextLong();

           	} 

           	System.out.println(o.solve(a, n));
           
        }
        
        sc.close();
    }
    
}
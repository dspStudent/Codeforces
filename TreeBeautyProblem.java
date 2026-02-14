import java.util.*;

public class TreeBeautyProblem {
	static int primes[]=new int[(int)1e5+1];


	Map<Integer, Map<Integer, Integer>> fre=new HashMap<>();
	Set<Integer> notCon=new HashSet<>();

	TreeBeautyProblem(){
		for(int i=2;i<=Math.sqrt(primes.length);i++){
			if(primes[i]==0){
				primes[i]=i;
				for(int j=2*i;j<primes.length;j+=i){
					if(primes[j]==0)
					primes[j]=i;
				}
			}
		}
	}

	class Ans{
		Map<Integer, Integer> fre=new HashMap<>();
		int ans;
		Ans(Map<Integer, Integer> fre, int ans){
			this.fre=fre;
			this.ans=ans;
		}
		Ans(){}

		String toString(Map<Integer, Integer> fre, int ans){
			return fre+" "+"ans"+" "+ans;
		}
	}

	void mergeMap(Map<Integer, Integer> freM, Map<Integer, Integer> dummy){
		for(int key: dummy.keySet()){
			freM.put(key, freM.getOrDefault(key, 0)+dummy.get(key));
		}
	}

	void dfs(int node, Map<Integer, List<Integer>> map, int par, int []val){

		System.out.println("node-> "+node+" par-> "+par);
		if(node==par){
			return ;
		}
		int ans=0;
		Map<Integer, Integer> freM=new HashMap<>();
		
		Map<Integer, Integer> dummy=fre.getOrDefault(node, new HashMap<>());
		dummy.put(val[node-1], dummy.getOrDefault(val[node-1], 0)+1);
		mergeMap(freM, dummy);
		fre.put(node, freM);

		System.out.println("merge node-> "+node+" par-> "+par+" dpFreeM "+freM+" dummy "+dummy);

			// return;
			if(!map.containsKey(node)){
				notCon.add(node);return;
			}
		
		for(int child: map.get(node)){
		System.out.println("node-> "+node+" child-> "+child);
			if(child != par){
				dfs(child, map, node, val);
				if(fre.containsKey(child)){
					System.out.println("node-> "+node+" child-> "+child+" dpFree "+fre);
					mergeMap(freM, fre.get(child));
					// freM.putAll(fre.get(child));
					System.out.println("node-> "+node+" child-> "+child+" dpFreeM "+freM);
				}
				// freM.put(val[node-1], freM.getOrDefault(val[node-1]))
				// Map<Integer, Integer> dummy=fre.getOrDefault(node, new HashMap<>());
				// dummy.put(val[node-1], dummy.getOrDefault(val[node-1], 0)+1);
				// mergeMap(freM, dummy);

				fre.put(node, freM);

			}
		System.out.println("node-> "+node+" child-> "+child+ " fre "+fre);

		}
		// return new Ans(fre, ans);
	}

	int solve(Map<Integer, List<Integer>> map, int val[]){
		dfs(1, map,0, val);
		int  count=0;
		for(int m: fre.keySet()){
			if(!notCon.contains(m))
			for(int key: fre.get(m).keySet()){
				if(fre.get(m).get(key)>1){
					int f=fre.get(m).get(key);
					count+=f*(f-1)/2;
					
				}
			}
		}
		return count;
	}

	public int getSqFree(int x){
		int res=1;
		while(x>1){
			int prime=primes[x], count=0;
			while(x>0 && x%prime==0){
				x=x/prime;
				count++;
			}
			if(count%2!=0) res=res*prime;
		}
		return res;
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeBeautyProblem ob=new TreeBeautyProblem();
        
        Map<Integer, List<Integer>> map=new HashMap<>();

        int n=sc.nextInt();
        int par[]=new int[n];

        for(int i=1;i<=n;i++){
        	par[i-1]=sc.nextInt();

        	if(map.containsKey(par[i-1])){
        		map.get(par[i-1]).add(i);
        	}
        	else{
        		map.put(par[i-1], new ArrayList<>(Arrays.asList(i)));
        	}
        }

        int val[]=new int[n];
        for(int i=0;i<n;i++){
        	val[i]=sc.nextInt();
        	val[i]=ob.getSqFree(val[i]);
        }

        System.out.println("map"+map);
        System.out.println("[primes] "+Arrays.toString(val));

        int ans=ob.solve(map, val);
        
        System.out.println(ans);

        sc.close();
    }
    
}
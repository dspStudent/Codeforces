import java.util.*;

public class ForeverWinter {

	String solve(int n, int e, Scanner sc){
		List<int[]> set=new ArrayList<>();
		List<List<Integer>> map=new ArrayList<>();
		int vis[]=new int[n+1];
		for(int i=0;i<n+1;i++)map.add(new ArrayList<>());
		for(int i=0;i<e;i++){
			int ed1=sc.nextInt();
			int ed2=sc.nextInt();
			map.get(ed1).add(ed2);
			map.get(ed2).add(ed1);
		}
		// System.out.println(map);

		Set<Integer> oneNode=new HashSet<>();

		for(int i=1;i<map.size();i++){
			if(map.get(i).size()==1)oneNode.add(i);
		}

		int y=0;
		
		int nonOnes=0;

		// System.out.println(oneNode);


		A:
		for(int i:oneNode){
			int yNode=map.get(i).get(0);
			y=yNode;
			for(int childs:map.get(yNode)){
				int onse=0;
				if(map.get(childs).size()==1){
					onse++;
				}
				else{
					nonOnes=childs;
					break A;
				}
			}
		}

		return (map.get(nonOnes).size()==0?1:map.get(nonOnes).size())+" "+(map.get(y).size()-1);

	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ForeverWinter o=new ForeverWinter();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            int e=sc.nextInt();
            
            System.out.println(o.solve(n, e, sc));
            
        }
        
        sc.close();
    }
    
    
}
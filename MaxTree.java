import java.util.*;
import java.io.InputStream;
import java.io.IOException;

public class MaxTree {

	static class FastScanner {
	    private final byte[] buffer = new byte[1 << 16];
	    private int ptr = 0, len = 0;
	    private final InputStream in = System.in;

	    private int readByte() throws IOException {
	        if (ptr >= len) {
	            len = in.read(buffer);
	            ptr = 0;
	            if (len <= 0) return -1;
	        }
	        return buffer[ptr++];
	    }

	    int nextInt() throws IOException {
	        int c, sign = 1, val = 0;

	        do {
	            c = readByte();
	        } while (c <= ' ');

	        if (c == '-') {
	            sign = -1;
	            c = readByte();
	        }

	        while (c > ' ') {
	            val = val * 10 + (c - '0');
	            c = readByte();
	        }

	        return val * sign;
	    }

	    long nextLong() throws IOException {
	        int c, sign = 1;
	        long val = 0;

	        do {
	            c = readByte();
	        } while (c <= ' ');

	        if (c == '-') {
	            sign = -1;
	            c = readByte();
	        }

	        while (c > ' ') {
	            val = val * 10 + (c - '0');
	            c = readByte();
	        }

	        return val * sign;
	    }

    String next() throws IOException {
        int c;
        StringBuilder sb = new StringBuilder();

        do {
            c = readByte();
        } while (c <= ' ');

        while (c > ' ') {
            sb.append((char) c);
            c = readByte();
        }

        return sb.toString();
    }
}

	void dfs(int node, Stack<Integer> st, List<Integer> []add, int[] vis){
		
		if(vis[node]!=0)return;

		vis[node]=1;

		for(int nodeChild: add[node]){
			if(vis[nodeChild]==0){
				// vis[nodeChild]=1;
				dfs(nodeChild, st, add, vis);

			}
		
			
		}
		st.push(node);
	}

    public static void main(String[] args) throws IOException{
        FastScanner sc = new FastScanner();
        MaxTree o=new MaxTree();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();

      		List<Integer> []ad=new ArrayList[n+1];

      		for(int i=1;i<=n;i++)ad[i]=new ArrayList<>();


      		for(int i=0;i<n-1;i++){
      			int node1=sc.nextInt();
      			int node2=sc.nextInt();
      			int u=sc.nextInt();
      			int v=sc.nextInt();

      			if(u>v){
      				ad[node1].add(node2);
      			}
      			else{
      				ad[node2].add(node1);
      			}
      			
      		}

      	
      		int top=n;
      		
    		
    		int in[]=new int[n+1];
    		// List<Integer> ans=new ArrayList<>();

    		Queue<Integer> pq=new ArrayDeque<>();

    		int an[]=new int[n+1];

    		for(int i=1;i<=n;i++){
    			for(int childs: ad[i]){
    				in[childs]++;
    			}
    			
    		}

    		for(int i=1;i<=n;i++)if(in[i]==0){
    			pq.add(i);
    			// ans.add(i);
    			an[i]=top;
    			top--;
    		}

    		// System.out.println(Arrays.toString(in));


    		while(!pq.isEmpty()){
    			int node=pq.remove();
    			for(int child: ad[node]){
    				in[child]--;
    				if(in[child]==0){
    					pq.add(child);
    					// ans.add(child);
    					an[child]=top;
    					top--;
    				}
    			}
    		}



    		// System.out.println(ans);

      		

      		StringBuilder sb=new StringBuilder();
      		for(int i=1;i<n;i++)sb.append(an[i]+" ");

      		sb.append(an[n]);

      		// System.out.println(Arrays.toString(a));
      		System.out.println(sb);


        }
        
        // sc.close();
    }


   
}

        
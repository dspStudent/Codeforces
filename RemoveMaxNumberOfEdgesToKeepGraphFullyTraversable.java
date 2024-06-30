import java.io.*;
import java.util.*;
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
	 public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointUnionSet dsu1 = new DisjointUnionSet(n + 1);
        DisjointUnionSet dsu2 = new DisjointUnionSet(n + 1);
        int count = 0;
        
        // Process type 3 edges first
        for (int[] ed : edges) {
            int type = ed[0], x = ed[1], y = ed[2];
            if (type == 3) {
                if (dsu1.ultPar(x) == dsu1.ultPar(y) && dsu2.ultPar(x) == dsu2.ultPar(y)) {
                    count++;
                } else {
                    dsu1.addEdegeBySize(x, y);
                    dsu2.addEdegeBySize(x, y);
                }
            }
        }        
        // Process type 1 and type 2 edges
        for (int[] ed : edges) {
            int type = ed[0], x = ed[1], y = ed[2];
            if (type == 1) {
                if (dsu1.ultPar(x) == dsu1.ultPar(y)) {
                    count++;
                } else {
                    dsu1.addEdegeBySize(x, y);
                }
            } else if (type == 2) {
                if (dsu2.ultPar(x) == dsu2.ultPar(y)) {
                    count++;
                } else {
                    dsu2.addEdegeBySize(x, y);
                }
            }
        }
        
        // Check if all nodes in dsu1 are connected
        int par1 = dsu1.ultPar(dsu1.dsu[1]);
        for (int i = 1; i <= n; i++) {
            if (par1 != dsu1.ultPar(dsu1.dsu[i])) {
                return -1;
            }
        }
        
        // Check if all nodes in dsu2 are connected
        int par2 = dsu2.ultPar(dsu2.dsu[1]);
        for (int i = 1; i <= n; i++) {
            if (par2 != dsu2.ultPar(dsu2.dsu[i])) {
                return -1;
            }
        }
        
        return count;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Read the value of n
		int n = Integer.parseInt(br.readLine().trim());
		// Read the number of edges
		int m = Integer.parseInt(br.readLine().trim());
		// Create an array to store the edges
		int[][] edges = new int[m][3];
		// Read the edges
		RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable o=new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
			edges[i][0]=Integer.parseInt(st.nextToken());
			edges[i][1]=Integer.parseInt(st.nextToken());
			edges[i][2]=Integer.parseInt(st.nextToken());
		}
		System.out.println(o.maxNumEdgesToRemove(n, edges));
	}
}

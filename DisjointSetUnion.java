import java.io.*;
import java.util.*;
public class DisjointSetUnion {
	   int[] dsu;
    int[] rank;
    int[] size;
    int max;
    int connectedComponents;

    DisjointSetUnion(int max) {
        this.max = max;
        dsu = new int[max];
        rank = new int[max];
        size = new int[max];
        connectedComponents = max; // Initially, each element is its own component
        Arrays.fill(rank, 0);
        Arrays.fill(size, 1);
        for (int i = 0; i < max; i++) {
            dsu[i] = i;
        }
    }

    public int supParent(int x) {
        if (x == dsu[x]) return x;
        return dsu[x] = supParent(dsu[x]);
    }

    private boolean isComponent(int x, int y) {
        return supParent(x) == supParent(y);
    }

    public void addUniByRank(int x, int y) {
        int parx = supParent(x);
        int pary = supParent(y);
        if (parx == pary) return;
        if (rank[parx] == rank[pary]) {
            dsu[pary] = dsu[parx];
            rank[parx]++;
        } else if (rank[parx] < rank[pary]) {
            dsu[parx] = dsu[pary];
        } else {
            dsu[pary] = dsu[parx];
        }
        connectedComponents--; // Two separate components are united
    }

    public void addUniBySize(int x, int y) {
        int parx = supParent(x);
        int pary = supParent(y);
        if (parx == pary) return;
        if (size[parx] > size[pary]) {
            dsu[pary] = parx;
            size[parx] += size[pary];
        } else {
            dsu[parx] = pary;
            size[pary] += size[parx];
        }
        connectedComponents--; // Two separate components are united
    }

    public int getConnectedComponents() {
        return connectedComponents;
    }
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	StringTokenizer st = new StringTokenizer(br.readLine());
	// 	int n = Integer.parseInt(st.nextToken());
	// 	int ed = Integer.parseInt(st.nextToken());
	// 	DisjointSetUnion dsu = new DisjointSetUnion(n);
	// 	while (ed-- > 0) {
	// 		StringTokenizer st1 = new StringTokenizer(br.readLine());
	// 		int x = Integer.parseInt(st1.nextToken()), y = Integer.parseInt(st1.nextToken());
	// 		// System.out.println(x+" "+y);
	// 		dsu.addEdegeBySize(x, y);
	// 	}
	// 	System.out.println(Arrays.toString(dsu.dsu));
	// 	System.out.println(Arrays.toString(dsu.size));
	// }
}
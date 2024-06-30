import java.io.*;
import java.util.*;
public class DisjointUnionSet {
	int dsu[];
	int rank[];
	int size[];
	DisjointUnionSet(int n) {
		dsu = new int[n];
		rank = new int[n];
		size = new int[n];
		Arrays.fill(size, 1);
		for (int i = 0; i < n; i++)dsu[i] = i;
	}
	public int ultPar(int x) {
		if (x == dsu[x])return x;
		return dsu[x] = ultPar(dsu[x]);
	}
	public void addEdegeBySize(int x, int y) {
		int parX = ultPar(x);
		int parY = ultPar(y);
		if (parX == parY)return;
		if (size[parY] > size[parX]) {
			dsu[parX] = parY;
			size[parY]+=size[parX];
			return ;
		}
		dsu[parY] = parX;
		size[parX]+=size[parY];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int ed = Integer.parseInt(st.nextToken());
		DisjointUnionSet dsu = new DisjointUnionSet(n);
		while (ed-- > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st1.nextToken()), y = Integer.parseInt(st1.nextToken());
			// System.out.println(x+" "+y);
			dsu.addEdegeBySize(x, y);
		}
		System.out.println(Arrays.toString(dsu.dsu));
		System.out.println(Arrays.toString(dsu.size));
	}
}
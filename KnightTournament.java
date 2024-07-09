import java.io.*;
import java.util.*;
public class KnightTournament {
	int n;
	int seg[];
	int lazy[];
	KnightTournament(int n) {
		this.n = n;
		seg = new int[4 * n];
		Arrays.fill(seg, -2);
		lazy = new int[4 * n];
		Arrays.fill(lazy, -2);
	}

	public void updateRange(int segStart, int segEnd, int qStart, int qEnd, int node, int val) {
		System.out.println(segStart + " " + segEnd + " " + node);

		if (lazy[node] != -2) {
			seg[node] = lazy[node];
			lazy[node] = -2;
			if (2 * node + 1 < 4 * n)
				lazy[2 * node + 1] = seg[node];
			if (2 * node + 2 < 4 * n)
				lazy[2 * node + 2] = seg[node];
		}
		if (segEnd < qStart || segStart > qEnd)return;
		if (segStart >= qStart && segEnd <= qEnd) {
			if (segEnd == segStart) {
				if (val == segStart) {
					seg[node] = -1;
				} else {
					seg[node] = val ;
				}
				return;
			}

			if (seg[node] == -2 || seg[node] == -1) {
				seg[node] = val ;
			}
			if (2 * node + 1 < 4 * n) {
					if(lazy[2*node+1]==-2 || lazy[2*node+1]==-1)
					lazy[2 * node + 1] = seg[node];
			}
			if (2 * node + 2 < 4 * n) {
					if(lazy[2*node+1]==-2 || lazy[2*node+1]==-1)
					lazy[2 * node + 2] = seg[node] ;
			}
			return;
		}
		int mid = segStart + (segEnd - segStart) / 2;
		updateRange(segStart, mid, qStart, qEnd, 2 * node + 1, val);
		updateRange(mid + 1, segEnd, qStart, qEnd, 2 * node + 2, val);
	}
	public void updateRange(int qStart, int qEnd, int val) {
		updateRange(0, n - 1, qStart, qEnd, 0, val);
	}
	public int getNode(int segStart, int segEnd, int node, int loc) {
		if (lazy[node] != 0) {
			seg[node] = lazy[node];
			lazy[node] = 0;
			if (2 * node + 1 < 4 * n)
				lazy[2 * node + 1] = seg[node];
			if (2 * node + 2 < 4 * n)
				lazy[2 * node + 2] = seg[node];
		}
		if (segStart == segEnd && segEnd == loc) {
			return seg[node];
		}
		int mid = segStart + (segEnd - segStart) / 2;
		return loc <= mid ? getNode(segStart, mid, 2 * node + 1, loc) : getNode(mid + 1, segEnd, 2 * node + 1, loc);
	}
	public int getNode(int loc) {
		return getNode(0, n - 1, 0, loc);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = 0;
		}
		KnightTournament seg = new KnightTournament(n);
		StringBuilder op = new StringBuilder();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()),
			    r = Integer.parseInt(st.nextToken()),
			    w = Integer.parseInt(st.nextToken());

			System.out.println("q "+ (l-1)+" "+(r-1)+" "+(w-1));    
			seg.updateRange(l - 1, r - 1, w - 1);

			System.out.println(Arrays.toString(seg.seg));
			System.out.println();
			System.out.println(Arrays.toString(seg.lazy));
			System.out.println("-------------");
		}


		System.out.println(Arrays.toString(seg.lazy));
		System.out.println();
		System.out.println(Arrays.toString(seg.seg));
	}
}
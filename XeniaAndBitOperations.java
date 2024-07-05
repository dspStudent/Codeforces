import java.io.*;
import java.util.*;
public class XeniaAndBitOperations {
	long seg[];
	int n;
	int lastOp = 0;
	public static int mathPow(int a, int p) {
		int res = 1;
		while (p != 0) {
			if ((p & 1) == 1)res *= a;
			a = a * a;
			p >>= 1;
		}
		return res;
	}
	public XeniaAndBitOperations(int n) {
		this.seg = new long[4 * n];
		this.n = n;
	}
	public int build(long a[], int segStart, int segEnd, int node) {
		// 0--> or_ opration
		// 1--> xor opration
		// System.out.println(segStart+" "+segEnd+" "+node+" "+whatOp);
		if (segEnd == segStart) {
			seg[node] = a[segEnd];
			return 0;
		}
		int mid = segStart + (segEnd - segStart) / 2;
		int opp=build(a, segStart, mid, 2 * node + 1);
		opp=build(a, mid + 1, segEnd, 2 * node + 2);
		seg[node] = opp == 0 ? (seg[2 * node + 1] | seg[2 * node + 2]) : (seg[2 * node + 1] ^ seg[2 * node + 2]);
		return 1-opp;
	}
	private long query(int segStart, int segEnd, int qStart, int qEnd, int node, int whatOp) {
		if (segEnd < qStart || segStart > qEnd) {
			return 0L;
		}
		if (qEnd <= segEnd && qStart <= segStart) {
			return seg[node];
		}
		int mid = segStart + (segEnd - segStart) / 2;
		long left = query(segStart, mid, qStart, qEnd, 2 * node + 1, 1 - whatOp);
		long right = query(mid + 1, segEnd, qStart, qEnd, 2 * node + 2, 1 - whatOp);
		return whatOp == 0 ? (left | right) : (left ^ right);
	}
	public long query(int qStart, int qEnd) {
		return query(0, n - 1, qStart, qEnd, 0, lastOp);
	}
	public int update(int segStart, int segEnd, int loc, long a, int node){
		if(segStart==loc && segEnd==loc){
			seg[node]=a;
			return 0;
		}
		int mid=segStart+(segEnd-segStart)/2;
		int opp=-1;
		if(loc<=mid)
			opp=update(segStart, mid, loc, a, 2*node+1);
		if(loc>mid)
			opp=update(mid+1, segEnd, loc, a, 2*node+2);
		seg[node] = opp == 0 ? (seg[2 * node + 1] | seg[2 * node + 2]) : (seg[2 * node + 1] ^ seg[2 * node + 2]);
		return 1-opp;
	}
	public void update(int loc, long a){
		update(0, n-1, loc, a, 0);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int n = mathPow(2, p);
		int q = Integer.parseInt(st.nextToken());
		long a[] = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}
		XeniaAndBitOperations seg = new XeniaAndBitOperations(n);
		seg.lastOp=seg.build(a, 0, n-1, 0);
		StringBuilder op = new StringBuilder();
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int loc=Integer.parseInt(st.nextToken())-1;
			long val=Long.parseLong(st.nextToken());
			seg.update(loc, val);
			op.append(seg.seg[0]).append("\n");
		}
		System.out.println(op);
	}
}
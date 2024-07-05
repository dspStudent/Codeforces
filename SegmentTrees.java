import java.io.*;
import java.util.*;
public class SegmentTrees<T extends Comparable<T>> {
	T[] seg;
	int n;
	T defaultValue;
	Class<T> clazz;
	@SuppressWarnings("unchecked")
	public SegmentTrees(Class<T> clazz, int n, T d) {
		this.clazz = clazz;
		this.n = n;
		defaultValue=d;
		seg = (T[]) java.lang.reflect.Array.newInstance(clazz, 4 * n);
	}

	public double sum(Number a, Number b) {
		return a.doubleValue() + b.doubleValue();
	}

	public int compare(T a, T b) {
		if(a==null)return -1;
		if(b==null)return 1;
		return a.compareTo(b);
	}

	public T getDefault(int node) {
		return compare(seg[2 * node + 1], seg[2 * node + 2]) > 0 ? seg[2 * node + 1] : seg[2 * node + 2];
	}

	public void build(T[] a, int start, int end, int node) {
		// System.out.println(start + " " + end + " " + node);
		if (start == end) {
			seg[node] = a[start];
			return;
		}
		int mid = start + (end - start) / 2;
		build(a, start, mid, 2 * node + 1);
		build(a, mid + 1, end, 2 * node + 2);
		seg[node] = getDefault(node);
	}
	private T query(int segStart, int segEnd, int qStart, int qEnd, int node){
		// System.out.println("Yes i am in "+segStart+" "+segEnd+" "+qStart+" "+qEnd+" "+node);
		// no overLap
		if(segEnd < qStart || qEnd<segStart){
			return defaultValue;
		}
		// complete overLap
		if(qStart<=segStart && qEnd<=segEnd){
			return seg[node];
		}
		int mid=segStart+(segEnd-segStart)/2;
		T left=query(segStart, mid, qStart, qEnd, 2*node+1);
		T right=query(mid+1, segEnd, qStart, qEnd, 2*node+2);
		return compare(left, right)!=-1?left:right;
	}
	public T query(int qStart, int qEnd){
		return query(0, this.n-1, qStart, qEnd, 0);
	}
	private void update(int segStart, int segEnd, int loc, T a, int node){
		if(segStart==loc && segEnd==loc){
			seg[node]=a;
			return;
		}
		int mid=segStart+(segEnd-segStart)/2;
		if(loc<=mid)
			update(segStart, mid,  loc,  a,  2*node+1);
		if(loc>mid)
			update(mid+1, mid,  loc,  a,  2*node+2);
		seg[node]=compare(seg[2*node+1], seg[2*node+2])==1?seg[2*node+1]:seg[2*node+2];
	}
	public void update(int loc, T a){
		update(0, n-1, loc, a, 0);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] a = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		SegmentTrees<Integer> seg = new SegmentTrees<>(Integer.class, n, Integer.MIN_VALUE);
		seg.build(a, 0, n - 1, 0);
		System.out.println(Arrays.toString(seg.seg));
		seg.update(1, 100);
		System.out.println(Arrays.toString(seg.seg));
		System.out.println(seg.query(0, 2));
	}
}

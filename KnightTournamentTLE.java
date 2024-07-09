import java.io.*;
import java.util.*;
public class KnightTournamentTLE {
    int n;
    int seg[];
    KnightTournamentTLE(int n) {
        this.n = n;
        this.seg = new int[4 * n];
        Arrays.fill(seg, -2);
    }
    public void updateRange(int segStart, int segEnd, int qStart, int qEnd, int node, int val) {
        // System.out.println(segStart+" "+segEnd+" "+qStart+" "+qEnd+" "+node);
        // System.out.println();
        if (segStart > segEnd || segStart > qEnd || segEnd < qStart)return;
        if (segStart == segEnd) {
            if(segStart==val){
                seg[node]=-1;
                return;
            }
            if(seg[node]==-1 || seg[node]==-2)
            seg[node] = val;

            return;
        }
        int mid = segStart + (segEnd - segStart) / 2;
        updateRange(segStart, mid, qStart, qEnd, 2 * node + 1, val);
        updateRange(mid + 1, segEnd, qStart, qEnd, 2 * node + 2, val);

    }
    public void updateRange(int qStart, int qEnd, int val) {
        updateRange(0, n - 1, qStart, qEnd, 0, val);
    }
    public int getNode(int segStart, int segEnd, int loc, int node){
        if(segStart==loc && segEnd==loc){
            return seg[node];
        }
        int mid=segStart+(segEnd-segStart)/2;
        return loc<=mid?getNode(segStart, mid, loc, 2*node+1):
        getNode(mid+1, segEnd, loc, 2*node+2);
    }
    public int getNode(int loc){
        return getNode(0, n-1, loc, 0)+1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 0;
        }
        KnightTournamentTLE seg = new KnightTournamentTLE(n);
        StringBuilder op = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()),
                r = Integer.parseInt(st.nextToken()),
                w = Integer.parseInt(st.nextToken());
            // System.out.println(l + " " + r + " " + w);
            seg.updateRange(l - 1, r - 1, w-1);
            // System.out.println(Arrays.toString(seg.seg));
            // System.out.println();
        }
        
        
        for(int i=0;i<n;i++)
            op.append(seg.getNode(i)+" ");
        System.out.println(op);
    }
}
// TC:- 2*nlogn


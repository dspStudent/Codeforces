import java.io.*;
import java.util.*;
public class FenficTree {
	long fen[];
	int n;
	public FenficTree(int n){
		this.fen=new long[n+1];
		this.n=n;
	}
	public void update(int loc, long k){
		loc++;
		while(loc<n+1){
			fen[loc]+=k;
			loc+=loc & (loc&-loc);
			
		}
	}
	public long prefSum(int loc){
		long sum=0L;
		while(loc!=0){
			sum+=fen[loc];
			loc=loc & (loc-1);
		}
		return sum;
	}
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder op=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        FenficTree fen=new FenficTree(n);
        for(int i=0;i<n;i++)
                fen.update(i, Long.parseLong(st.nextToken()));
    	op.append(fen.prefSum(3));
        System.out.println(op);
    }
}
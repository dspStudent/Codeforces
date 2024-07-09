import java.io.*;
import java.util.*;
public class TowerOfHanoiCsese {
	public static StringBuilder op=new StringBuilder();
	public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private void solve(int n, char s, char d, char h){
		if(n<=0)return;
		solve(n-1, s, h, d);
		op.append(s+" "+d).append("\n");
		solve(n-1, h, d, s);
	}
    public static void main(String[] args) throws IOException{ 
     	
        int n = Integer.parseInt(br.readLine());
        
        TowerOfHanoiCsese o=new TowerOfHanoiCsese();
        op.append((1<<n)-1).append("\n");
        o.solve(n, '1', '3', '2');
        System.out.println(op);
    }
}



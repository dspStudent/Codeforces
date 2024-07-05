import java.io.*;
import java.util.*;
public class GrayCode {
	StringBuilder syso=new StringBuilder();
	private void solve(int n){
		List<String>ans=new ArrayList<>();
		ans.add("0");
		ans.add("1");
		for(int i=2;i<=n;i++){
			int size=ans.size();
			for(int j=size-1;j>=0;j--){
				ans.add(ans.get(j));
			}
			for(int j=0;j<size;j++){
				ans.set(j, "0"+ans.get(j));
				ans.set(j+size, "1"+ans.get(j+size));
			}
		}
		for(String s:ans)syso.append(s).append("\n");
	}
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       	GrayCode o=new GrayCode();
       	o.solve(n);
        System.out.println(o.syso);
    }
}

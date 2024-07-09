import java.io.*;
import java.util.*;
public class GenerateBinaryStringsWithoutAdjacentZerosLeetCode7July2 {
	List<String>ans;
	private void f(int n, String s,boolean shouldITakeZero){
		if(n==0){
			ans.add(s);
			return;
		}
		if(shouldITakeZero)
			f(n-1, s+"0", false);
		f(n-1, s+"1", true);
	}
	public List<String> validStrings(int n) {
		ans=new ArrayList<>();
		f(n, "",true);
		return ans;
	}
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder op=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        GenerateBinaryStringsWithoutAdjacentZerosLeetCode7July2 o=new GenerateBinaryStringsWithoutAdjacentZerosLeetCode7July2();
     	op.append(o.validStrings(n));
        System.out.println(op);
    }
}
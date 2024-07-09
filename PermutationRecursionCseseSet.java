import java.io.*;
import java.util.*;
public class PermutationRecursionCseseSet {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder op = new StringBuilder();
	public static StringTokenizer st;
	static TreeSet<String>set=new TreeSet<>();
	// static List<String>set=new ArrayList<>();
	private void solve(int i, String s){
		if(i>=s.length())return;
		set.add(s);
		for(int it=i;it<s.length();it++){
			StringBuilder sb=new StringBuilder(s);
			char c=s.charAt(i);
			sb.setCharAt(i, sb.charAt(it));
			sb.setCharAt(it, c);
			solve(i+1, sb.toString());
			c=s.charAt(i);
			sb.setCharAt(i, sb.charAt(it));
			sb.setCharAt(it, c);
		}
	}
	private void run(String s){
		solve(0, s);
	}
	public static void main(String[] args) throws IOException {
		String s=br.readLine();
		PermutationRecursionCseseSet o=new PermutationRecursionCseseSet();
		o.run(s);
		op.append(set.size()).append("\n");
		for(String i:set)op.append(i).append("\n");
		System.out.println(op);
	}
}

// 			        a b c 

// 	a b c           b a c              c b a 

// a b c  a c b    b a c    b c a    c b a    c a b 



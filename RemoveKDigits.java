import java.util.*;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int n = num.length();
		if (n == k)return "0";
		Stack<Character>st = new Stack<>();
		int start = 0;
		while (start < n) {
			char c=num.charAt(start);
			while(k>0 && st.isEmpty()==false && st.peek()>c){
				st.pop();k--;
			}
			st.push(c);
			start++;
		}

		while(k>0){
			st.pop();k--;
		}
		System.out.println(st);
		StringBuffer sb=new StringBuffer();
		while(st.isEmpty()==false)sb.append(st.pop());
		System.out.println(sb);
		sb=sb.reverse();
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int k = sc.nextInt();
		// System.out.println("hlo");
		RemoveKDigits rkd = new RemoveKDigits();
		System.out.println(rkd.removeKdigits(num, k));
		sc.close();
	}

}
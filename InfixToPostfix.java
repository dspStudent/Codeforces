import java.util.*;

public class InfixToPostfix {
	private boolean isOprend(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	private int getRank (char c) {
		if(c=='(')return 0;
		if (c == '+')return 1;
		if (c == '-')return 1;
		if (c == '*')return 2;
		if (c == '/')return 2;
		return 3;
	}
	private boolean canWePush (char o1, char o2) {
		return getRank(o1) <= getRank(o2);
	}
	private String infixToPostfix(String s) {
		Stack<Character>st = new Stack<>();
		String ans = "";
		for (char c : s.toCharArray()) {
			if(c=='('){
				st.push(c);
				continue;
			}
			if(c==')'){
				while(!st.isEmpty() && st.peek()!='(')ans+=st.pop()+"";
				// if(!st.isEmpty())
				st.pop();
				continue;
			}
			if(c=='(' || c==')')continue;
			if (isOprend(c)) {
				ans += c + "";
				continue;
			}
			while (!st.isEmpty() && !canWePush(st.peek(), c)) {
				ans += st.pop() + "";
			}
			st.push(c);
		}
		while (!st.isEmpty())ans += st.pop() + "";
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			String ans = "";
			InfixToPostfix itp = new InfixToPostfix();
			ans = itp.infixToPostfix(s);
			System.out.println(ans);
		}
		sc.close();
	}
}
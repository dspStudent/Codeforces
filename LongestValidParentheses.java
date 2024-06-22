import java.util.*;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int ans=0, temp=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push(temp);
                temp=0;
            }
            else{
                if(st.isEmpty()){
                    ans=Math.max(ans, temp);
                    temp=0;
                }
                else{
                    temp+=st.pop();
                    temp+=2;
                    ans=Math.max(ans, temp);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        LongestValidParentheses lvp=new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses(s));
    }
}
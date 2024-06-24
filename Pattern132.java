import java.util.*;

public class Pattern132 {
    public boolean find132pattern(int[] a) {
        int n=a.length;
        Stack<Integer>st=new Stack<>();
        int kel=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(a[i]<kel)return true;
            while(!st.isEmpty() && st.peek()<a[i]){
                kel=st.pop();
            }
            st.push(a[i]);
            System.out.println(i+" "+kel+" ");
        }
        // System.out.println();
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String s[] = input.substring(1, input.length() - 1).split(",");
        int a[] = Arrays.stream(s).mapToInt(i->Integer.parseInt(i)).toArray();
        Pattern132 p132 = new Pattern132();
        System.out.println(p132.find132pattern(a));
        sc.close();
    }
}
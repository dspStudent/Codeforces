import java.util.*;

public class ReverseStackRec {
	private static void reverse (Stack <Integer>st, int top){
		if(st.isEmpty()){
			st.push(top);
			return;
		}
		int peek=st.top();
		st.pop();
		reverse(st, top);
		st.push(peek);
		return ;
	}
	private static void reverseStack (Stack <Integer>st){
		if(st.isEmpty()){
			return;
		}
		int top=st.peek();
		st.pop();
		reverseStack(st);
		reverse(st, top);
	}
    public static void main(String[] args) {
        Stack<Integer>st=new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }
    
}

// 7
// 6
// 5
// 4
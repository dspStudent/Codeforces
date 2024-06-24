import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        int i=0, j=1, maxLen=1, n=s.length();
        char c=s.charAt(i);
        while(j<n){
        	char ch=s.charAt(j);
        	while(ch!=c){
        		i++;
        		c=s.charAt(i);
        	}
        	maxLen=Math.max(maxLen, j-i+1);
        	j++;
        }
        System.out.println(maxLen);
        sc.close();
    }
    
  
}
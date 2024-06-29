import java.util.*;

public class PermutationsCsese {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        // if(n==4){System.out.println("2 4 1 3 ");return;}
        StringBuilder sb=new StringBuilder();
        if(n>=2 && n<=3)System.out.println("NO SOLUTION");
        else{
        	for(int i=2;i<=n;i+=2){
        		sb.append(i+" ");
        	}
        	for(int i=1;i<=n;i+=2){
        		sb.append(i+" ");
        	}
        }
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;
public class ArrayDivisibilityCfCon1St {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder op=new StringBuilder();
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException{ 
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n=Integer.parseInt(br.readLine());
            for(int i=1;i<=n;i++){
            	op.append(i+" ");
            }
            op.append("\n");
        }
        System.out.println(op);
    }
}




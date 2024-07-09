import java.io.*;
import java.util.*;
public class AverageWaitingTime {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;

    public double averageWaitingTime(int[][] a) {
    	int n=a.length;
    	long waitSum=0, makingTime=0;
    	for(int i=0;i<n;i++){
    		int startTime=a[i][0];
    		makingTime=Math.max(makingTime, startTime);
    		int makeTime=a[i][1];
    		makingTime+=makeTime;
    		waitSum+=makingTime-startTime;
    	}
    	return (double)waitSum/(double)n;
    }

    public static void main(String[] args) throws IOException{ 
        AverageWaitingTime o=new AverageWaitingTime();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
            int n=sToInt(br.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
            	a[i]=nextIntA(2);
            }
            op.append(o.averageWaitingTime(a)).append("\n");
        }
        System.out.println(op);
    }





















    public static int[] nextIntA(int n)throws IOException{
        int a[]=new int[n];
        st=nst(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=sToInt(st.nextToken());
        }
        return a;
    }
    public static int sToInt(String s){
        return Integer.parseInt(s);
    }
    public static long sToLong(String s){
        return Long.parseLong(s);
    }
    public static int sToInt(char c){
        return Integer.parseInt(c+"");
    }
    public static long sToLong(char c){
        return Long.parseLong(c+"");
    }
    public static StringTokenizer nst(String s){
        return new StringTokenizer(s);
    }
}
import java.io.*;
import java.util.*;
public class TemperatureIncrease {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static StringBuilder op=new StringBuilder();

    public static StringTokenizer st;


    public static int solve(List<Integer>a){
    	int n=a.size();
    	int ans=0, max=a.get(n-1);
    	for(int i=n-1;i>=0;i--){
    		ans=Math.max(ans, max-a.get(i));
    		max=Math.max(a.get(i), max);
    	}
    	return ans;
    }
    public static void main(String[] args) throws IOException{ 
        TemperatureIncrease o=new TemperatureIncrease();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
        	int n=sToInt(br.readLine());
            int a[]=nextIntA(n);
            List<Integer>ar=new ArrayList<>();
            for(int i:a)ar.add(i);
            op.append(o.solve(ar)).append("\n");
        }
        System.out.println(op);
    }


















    //<BinarySearch>

    //<UpperBoud>

    public static int upperBound(List<Integer>a, int k){
        int n=a.size();
        int start=0, end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(k>a.get(mid)){
                start=mid+1;
            }
            else end=mid;
        }
        return end;
    }

    public static int upperBound(int[] a, int k){
        int n=a.length;
        int start=0, end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(k>a[mid]){
                start=mid+1;
            }
            else end=mid;
        }
        return end;
    }

    //<UpperBoud/>

    // <inputs> 

    public static int[] nextIntA(int n)throws IOException{
        int a[]=new int[n];
        st=nst(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=sToInt(st.nextToken());
        }
        return a;
    }

    //<BinarySearch/>

    //<input/>

    // string/char to number
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

    //StringTokenIzer
    public static StringTokenizer nst(String s){
        return new StringTokenizer(s);
    }

}
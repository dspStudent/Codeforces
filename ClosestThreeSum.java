import java.io.*;
import java.util.*;
public class ClosestThreeSum {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public  StringBuilder op=new StringBuilder();

    public static StringTokenizer st;

    static List<Integer>li=new ArrayList<>();
    static void f(int i, int sum, int k, int []a){
    	if(i<a.length && k==0){
    		li.add(sum);
    		return ;
    	}
    	if(i>=a.length)return;
    	f(i+1, sum+a[i], k-1, a);
    	f(i+1, sum, k, a);
    }
    static int threeSumClosest1(int[] a, int k) {
    	int n=a.length;
        f(0, 0, 3, a);
        Collections.sort(li);
        // op.append(li).append("\n");
        int upB=upperBound(li, k);
        // op.append(upB).append("\n");
        if(upB>0 && a[upB-1]==k)return k;
        if(upB==li.size())return li.get(upB-1);
        return li.get(upB);
    }
    static int threeSumClosest(int a[], int k){
    	Arrays.sort(a);
    	int n=a.length, ans=0, min=Integer.MAX_VALUE;
    	for(int i=0;i<n;i++){
    		int sum=k-a[i];
    		int start=i+1, end=n-1;
    		while(start<end){
    			int summ=a[start]+a[end];
    			if(min==Math.abs(summ-sum)){
    				ans=Math.max(summ+a[i], ans);
    			}
    			if(min> Math.abs(summ-sum)){
    				min=Math.abs(summ-sum);
    				ans=summ+a[i];
    			}
    			if(summ==sum)return k;
    			if(summ>sum){
    				end--;
    			}
    			else{
    				start++;
    			}
    		}
    	}
    	return ans;
    }


    public static void main(String[] args) throws IOException{ 
        ClosestThreeSum o=new ClosestThreeSum();
        int t = sToInt(br.readLine());
        while(t-- > 0) {
        	int n=sToInt(br.readLine());
            int a[]=nextIntA(n);
            int k=sToInt(br.readLine());
            o.op.append(threeSumClosest(a, k)).append("\n");;
        }
        System.out.println(o.op);
    }


















    public static int intMax(){
    	return Integer.MAX_VALUE;
    }
    public static int intMin(){
    	return Integer.MIN_VALUE;
    }
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


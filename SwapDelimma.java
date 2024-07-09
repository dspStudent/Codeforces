import java.io.*;
import java.util.*;
public class SwapDelimma {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static StringBuilder op = new StringBuilder();

	public static StringTokenizer st;

	private long merge(int a[], int start, int mid, int end){

		int i=start, j=mid+1,  it=0;
		long count=0;
		int empty[]=new int[end-start+1];
		while( i <=mid && j<=end){
			if(a[i]>a[j]){
				count+=mid-i+1;
				empty[it]=a[j];
				j++;
			}
			else{
				empty[it]=a[i];
				i++;
			}
			it++;
		}
		while(i<=mid){
			empty[it]=a[i];
			i++;it++;
		}
		while(j<=end){
			empty[it]=a[j];
			j++;it++;
		}
		int it1=0;
		// System.out.println(Arrays.toString(empty)+" emp");
		for(int k=start;k<=end;k++)a[k]=empty[it1++];
		return count;
	}
	private long mergeSort(int a[], int start, int end){
		if(start>end)return 0;
		if(start==end)return 0;
		int count=0;
		int mid=start+(end-start)/2;
		count+=mergeSort(a, start, mid);
		count+=mergeSort(a, mid+1, end);
		count+=merge(a, start, mid, end);
		return count;
	}

	private long invCount(int a[]){
		return mergeSort(a, 0, a.length-1);
	}

	private void run(int a[], int b[]) {
		long tA=invCount(a);
		long tB=invCount(b);
		// System.out.println(tA+" "+tB+" "+Arrays.toString(a)+" "+Arrays.toString(b));
		// System.out.println(tA+" "+tB);
		for(int i=0;i<a.length;i++)if(a[i]!=b[i]){
			op.append("No").append("\n");
			return;
		}
		if(tA==0 && tB%2==0 || tA%2==0 && tB==0 || tB==tA){
			op.append("Yes").append("\n");
			return;
		}
		if(tA!=tB && Math.abs(tA-tB)%2==0){
			op.append("Yes").append("\n");
			return;
		}
		
		
		op.append("No").append("\n");
	}

	public static void main(String[] args) throws IOException {
		int t = sToInt(br.readLine());
		SwapDelimma o = new SwapDelimma();
		while (t-- > 0) {
			int n = sToInt(br.readLine());
			int a[]=nextIntA(n);
			int b[]=nextIntA(n);
			// o.mergeSort(a, 0, n-1);
			o.run(a, b);
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
	public static int sToInt(String s) {
		return Integer.parseInt(s);
	}
	public static long sToLong(String s) {
		return Long.parseLong(s);
	}
	public static int sToInt(char c) {
		return Integer.parseInt(c + "");
	}
	public static long sToLong(char c) {
		return Long.parseLong(c + "");
	}
	public static StringTokenizer nst(String s) {
		return new StringTokenizer(s);
	}
}


import java.util.*;
public class MinimumNumberOfKConsecutiveBitFlips {
	public int minKBitFlips(int[] a, int k) {
		int n = a.length;
		int ans=0, times=0;
		boolean isFilped[]=new boolean[n];
		for(int i=0;i<n;i++){
			if(i+1<=k){
				if(a[i]%2==times%2){
					times++;
					isFilped[i]=true;
				}
				continue;
			}
			if(isFilped[i-k])times--;
			if(a[i]%2==times%2){
				if(n-i+1<=k)return -1;
				isFilped[i]=true;
				times++;
			}
		}
		for(boolean flips:isFilped)if(flips)ans++;
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String s[] = input.substring(1, input.length() - 1).split(",");
		int k = sc.nextInt();
		int a[] = Arrays.stream(s).mapToInt(i->Integer.parseInt(i)).toArray();
		MinimumNumberOfKConsecutiveBitFlips mc = new MinimumNumberOfKConsecutiveBitFlips();
		System.out.println(mc.minKBitFlips(a, k));
		sc.close();
	}
}





import java.util.Scanner;
public class CoverInWater{
	public static int f(String s){
		String str[]=s.split("#");
		// System.out.println(Arrays.toString(str));
		int ans=0;
		for(String s1:str){
			if(s1.length()>2)return 2;
			ans+=s1.length();
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			String q=sc.next();
			System.out.println(f(q));
		}
	}
}
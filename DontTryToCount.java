import java.util.Scanner;
public class DontTryToCount{
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
			int m=sc.nextInt();
			String  ns=sc.next();
			String  ms=sc.next();
			int c=0;
			while(ns.contains(ms)==false){
				ns+=ns;
				c++;
				if(c>5){
					c=-1;
					break;
				}
			}
			System.out.println(c);
		}
	}
}
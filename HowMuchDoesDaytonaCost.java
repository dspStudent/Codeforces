import java.util.Scanner;
public class HowMuchDoesDaytonaCost{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int k=sc.nextInt();
			boolean tf=false;
			for(int i=0;i<n;i++){
				if(sc.nextInt()==k)tf=true;
			}
			if(tf)
			System.out.println("yes");	
			else System.out.println("no");
		}
	}
}
import java.util.Scanner;
public class HalloumiBoxes{
	public static void main(String[] args) {
		Scanner fs=new Scanner(System.in);
		int t=fs.nextInt();
		while(t-->0){
			int n=fs.nextInt();
			int k=fs.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)a[i]=fs.nextInt();
			if(k>=2)System.out.println("YES");
			else {
					int com=a[0];
					boolean f=true;
					for(int i=0;i<n;i++){
						if(com<=a[i]){
							com=a[i];
						}
						else {
							System.out.println("NO");
							f=false;
							break;
						}
					}
					if(f)
					System.out.println("YES");
			}
		}
	}
}
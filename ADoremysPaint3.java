import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class ADoremysPaint3{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			HashMap<Integer, Integer>map=new HashMap<>();
			ArrayList<Integer>list=new ArrayList<>();
			for(int i=0;i<n;i++){
				int x=sc.nextInt();
				if(map.containsKey(x)){
					map.put(x, map.get(x)+1);
				}
				else {
					list.add(x);
					map.put(x, 1);
				}
			}
			// System.out.println(map);
			if(map.size()==1)System.out.println("yes");
			else if(map.size()==2){
				int x=map.get(list.get(0));
				int y=map.get(list.get(1));
				if(n%2==0 && x==y)System.out.println("yes");
				else if(n%2!=0 && x+1==y || y+1==x)System.out.println("yes");
				else System.out.println("no");
			}
			else System.out.println("no");
		}
	}
}
// C:\Users\dsp\AppData\Roaming\Sublime Text\Packages\User
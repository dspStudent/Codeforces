import java.util.*;

public class Shuffle {
	int solve(int a[][], int x, int m){

		int from=0;

		int fromLeft=x;
		int fromRight=x;

		for(int i=0;i<m;i++){
			int left=a[i][0];
			int right=a[i][1];

			if(x>=left && x<=right){
				from=i;
				fromLeft=left;
				fromRight=right;
				break;
			}
		}

		// if(fromLeft==fromRight)return 1;

		// System.out.println(" fromLeft "+fromLeft+" fromRight "+fromRight+" from "+from);

		for(int i=from+1;i<m;i++){
			int nextleft=a[i][0];
			int nextRight=a[i][1];

			if(((fromRight>= nextleft) && (fromLeft<=nextleft || fromLeft<=nextRight))){
				fromLeft=Math.min(nextleft, fromLeft);
				fromRight=Math.max(nextRight, fromRight);
			}
		}


		return fromRight-fromLeft+1;

	}

    public static void main(String[] args) {
    	Shuffle o=new Shuffle();
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {

            int n = sc.nextInt();
            int x=sc.nextInt();
            int m=sc.nextInt();

            int a[][]=new int[m][2];
            for(int i=0;i<m;i++){
            	a[i][0]=sc.nextInt();
            	a[i][1]=sc.nextInt();
            }

            System.out.println(o.solve(a, x, m));
         
        }
        
        sc.close();
    }
    

}
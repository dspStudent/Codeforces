import java.util.*;

public class BallsGame {

	int f(int a[], int i, int j){

		if(i<0 || j>=a.length)return 0;
		int x=0;
		if(i>=0 && j<a.length){
			if(a[i]!=a[j])return 0;
			x=a[i];
		}
		i--;
		j++;
		int inC=2;
		// single
		while(j<a.length && a[j]==x){
			if(a[j]==x)inC++;
			j++;
		}

		while(i>=0 && a[i]==x){
			if(a[i]==x)inC++;
			i--;
		}

		int count=inC;

		if(inC>=3){
			count+=f(a, i, j);
		}

		return count>2 ? count: 0;
	}

	int solve(int a[], int n, int k, int x){

		if(n<=1)return 0;

		int max=0;

		int i=0;

		while(i<n){
						// System.out.println("i "+i);

			if(a[i]==x){
				int count=1;
				int j=i+1;
				while(j<n){
					
					if(a[j]==x)count++;
					else break;

					j++;
				
				}
				if(count>=2){
					max=Math.max(max, count+f(a, i-1, j));
				}
				i=j;
			}else{
				i++;
			}
		}

		return max;


	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BallsGame o=new BallsGame();
        
        // Read the number of test cases
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        int a[]=new int[n];

        for(int i=0;i<n;i++)a[i]=sc.nextInt();

        System.out.println(o.solve(a, n, k, x));

        
       	
        sc.close();
    }
    

}
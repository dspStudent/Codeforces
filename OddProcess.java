import java.util.*;

public class OddProcess {
	static void  printZeros(int n){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){

			sb.append("0"+" ");

		}
            System.out.println(sb);


	}

	static void printEv(int n, int el){
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=n;i++){
			if(i%2==0)
			sb.append("0"+" ");
			else
				sb.append(el+" ");
		}
            System.out.println(sb);


	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            List<Integer> odd=new ArrayList<>();
            List<Integer> ev=new ArrayList<>();

            for(int i=0;i<n;i++){
            	int el=sc.nextInt();
            	if(el%2==0){
            		ev.add(el);
            	}else{
            		odd.add(el);
            	}
            }
            // System.out.println("hi");
            Collections.sort(odd, (x, y)->y-x);
            Collections.sort(ev, (x, y)-> y-x);

            int oddP=0, evP=0;
            long sum=0;

            if(odd.isEmpty()){
            	printZeros(n);
            	continue;
            }

            if(ev.isEmpty()){
            	printEv(n, odd.get(oddP));
            	continue;
            }


            StringBuilder sb=new StringBuilder();

            sum=odd.get(oddP);
            int o=1;
            sb.append(sum+" ");

            for(int i=2;i<=n;i++){
            	if(evP==ev.size()){
            		// int rem=i-1-evP-o;
            		if(odd.size()-o==1){
            			sb.append("0");
            			break;
            		}
            		sum=sum-ev.get(evP-1);
            		evP--;
            		o+=2;
            	}else{
            		sum+=ev.get(evP);
            		evP++;
            	}
            	sb.append(sum+" ");
            }

            System.out.println(sb);
          
        }
        
        sc.close();
    }
    

}

// n=5
// 4 2 3 1 3

// 3 3 1
// 4 2

// o=3, evp= 1

// i=1 -> sum= 3
// i=2 -> sum= 3+ 4 = 7
// i=3 -> sum= 7+2 = 9
// i=4 -> sum=7
// i=5 -> sum=9


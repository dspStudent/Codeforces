import java.util.*;

public class SharkySurfing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int hn = sc.nextInt();
            int pn = sc.nextInt();
            int end = sc.nextInt();

            int h[][]=new int[hn][2];
            for(int i=0;i<hn;i++){
            	h[i][0]=sc.nextInt();
            	h[i][1]=sc.nextInt();
            	
            }

            int p[][]=new int[pn][2];
            for(int i=0;i<pn;i++){
            	p[i][0]=sc.nextInt();
            	p[i][1]=sc.nextInt();

            }

            int pi=0;
            PriorityQueue<Integer> pq=new PriorityQueue<>((x, y)-> y-x);
            int power=1, count=0;
            A:
            for(int i=0;i<hn;i++){
            	int sp=h[i][0];
            	int ep=h[i][1];
            	int need=ep-sp+2;
            	if(power>=need)continue;
            	while(pi<pn){
            		if(sp<p[pi][0]){

            			while(power<need && !pq.isEmpty()){
            				int pow=pq.remove();
            				count++;
            				power+=pow;
            				
            			}

            			if(power < need){
            				// System.out.println("-1");
            				count=-1;
            				break A;
            			}
            			break;

            		}
            		else{
            			pq.add(p[pi][1]);
            			pi++;
            		}
            	}

            	if(pi==pn && power<need){
            		while(power<need && !pq.isEmpty()){
            			int pow=pq.remove();
        				count++;
        				power+=pow;
            		}
            	}

        		if(power < need){
        				count=-1;
            				// break A;
        				break A;
        			}


            }

            System.out.println(count);


            
        }
        
        sc.close();
    }

}
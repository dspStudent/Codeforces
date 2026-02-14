import java.util.*;

public class TheCunningSellerHardVersion {

	long pow[]=new long[22];

	TheCunningSellerHardVersion(){
		pow[0]=1;
		for(int i=1;i<21;i++){
			pow[i]=pow[i-1]*3;
		}
	}

	long value(int x){
		return pow[x+1] + x*(x==0?x:pow[x-1]);
	}

	long solve(long n, long deals){

		int d[]=new int[21];
		long minDeals=0;
		long ans=Long.MAX_VALUE;
		int deal=0;
		long temp=n;

		while(temp>0){
			int maxPower=0;

			while(pow[maxPower]<=temp) maxPower++;
			maxPower--;
			d[maxPower]++;
			temp-=pow[maxPower];
			deal++;
		}
		// System.out.println(Arrays.toString(d)+" "+deal);

		if(deal > deals)return -1;

		int maxCan=21;

		while(deal<=deals){
			int maxDeal=0, maxDealTimes=0;
			long min=0;

			for(int i=d.length-1;i>=0;i--){
				if(d[i]!=0){
					maxDeal=Math.max(i, maxDeal);
				}
				min+=d[i]*value(i);
			}
			ans=Math.min(ans, min);

			// System.out.println("d "+Arrays.toString(d)+" deal "+deal+" maxDeal "+maxDeal);
			// System.out.println("ans "+ans);


			if(maxDeal==0){
				break;
			};
		
			long dealsLeft=deals-deal;
			if(dealsLeft<=1)break;
			if(dealsLeft >= d[maxDeal]*2){
					deal+=2*d[maxDeal];
					d[maxDeal-1]+=3*d[maxDeal];
					d[maxDeal]=0;
			}else{
				deal+=(dealsLeft%2==0?dealsLeft-1:dealsLeft);
				d[maxDeal-1]+=3*(dealsLeft/2);
				d[maxDeal]-=(dealsLeft/2);
			}
			// System.out.println("deal "+maxDeal);
		}

		

		return ans;


	}
    public static void main(String[] args) {
    	TheCunningSellerHardVersion o=new TheCunningSellerHardVersion();
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            long n = sc.nextLong();
            long deals=sc.nextLong();
            System.out.println(o.solve(n, deals));
        }

        // System.out.println(Math.log(10)/ Math.log(3)+" "+(long)Math.pow(3, 19));
        
        sc.close();
    }
    
}
import java.util.*;

public class Chemistry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        // System.out.println(t);
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
  			int k=sc.nextInt();
  			
  			Map<Character, Integer> map=new HashMap<>();

  			String s=sc.next();

  			int ev=0;
  			int max=0;
  			Map<Character, Integer> odMap=new HashMap<>();

  			for(char c: s.toCharArray()){
  				map.put(c, map.getOrDefault(c, 0)+1);
  			}

  			for(char i:map.keySet()){
  				if(map.get(i)%2==0){
  					ev+=map.get(i);
  				}else{
  					max=Math.max(max, map.get(i));
  					odMap.put(i, map.get(i));
  				}
  			}

  			
  			if(n%2!=k%2){

  				int need=n-k;
  				need-=max;
  				for(char i:odMap.keySet()){
  				if(odMap.get(i)==max){odMap.remove(i);break;}
  			}

  				if(need<=0){
  					System.out.println("Yes");
  				}
  				else{
  					need-=ev;
  					if(need<=0){
  					System.out.println("Yes");

  					}
  					else{
  						for(char i:odMap.keySet()){
  							need-= (odMap.get(i)-(odMap.get(i)%2));
  							if(need<=0){
  								break;
  							}
  						}

  						if(need<=0){
  								System.out.println("yes");
  							}else
  						System.out.println("No");
  					}
  				}
  			}else{

  				int need=n-k-ev;
  				
  					if(need<=0){
  						System.out.println("Yes");

  					}else{
  						
  						for(char i:odMap.keySet()){
  							need-= (odMap.get(i)-(odMap.get(i)%2));
  							if(need<=0){
  								break;
  							}
  						}


  						if(need<=0){
  								System.out.println("yes");
  							}else
  						System.out.println("No");
  					}
  				

  			}

  			// System.out.println(map);

        }
        
        sc.close();
    }
    
}


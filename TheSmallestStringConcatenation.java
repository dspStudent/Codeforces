import java.util.*;
public class TheSmallestStringConcatenation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        ArrayList<String>list=new ArrayList();
        for(int i=0;i<n;i++){
        	list.add(sc.next());
            // System.out.println(1);
            }
        Collections.sort(list, (i, j)->{
        	int is=0, js=0,ilen=i.length(), jlen=j.length();
        	while(is<ilen && js<jlen){
        		if(i.charAt(is)!=j.charAt(js))return i.charAt(is)-j.charAt(js);
                is++; js++;
        	}
        	return 0;
        });

        System.out.println(String.join("", list));
        sc.close();
    }
    
}
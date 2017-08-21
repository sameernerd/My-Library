import java.util.*;
import java.io.*;
import java.math.*;
 
import static java.lang.System.out;
 
 class ContestMain {
	private static int max=Integer.MIN_VALUE;
	private static int min=Integer.MAX_VALUE;
	private static Scanner in=new Scanner(System.in);
  
	public static void main(String[] args) throws IOException{
		ArrayList<Integer> ar=new ArrayList();
		HashSet<Integer> hash=new HashSet();
		long sum;
		for(int i=1;i<=100000;i++){
			sum=0;
			for(int j=2;j<Math.sqrt(i);j++){
				if(i%j==0){
					sum=sum+j+i/j;
				}
			}
			sum+=1;
			if(sum>i){
				ar.add(i);
				hash.add(i);
			}
		}
		int  t=in.nextInt(),num,j;
		for(int i=0;i<t;i++){
			num=in.nextInt();
			if(num>28123){
				System.out.println("YES");
				continue;
			}
			for(j=0;j<ar.size();j++){
				if(hash.contains(num-ar.get(j))){
					break;
				}
			}
			if(j==ar.size())out.println("NO");
			else out.println("YES");
		}
	}	
}

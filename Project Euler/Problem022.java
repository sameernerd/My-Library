import java.util.*;
import java.io.*;
import java.math.*;

import Library.BinaryTree;
 
import static java.lang.System.out;
 
 class ContestMain {
	private static int max=Integer.MIN_VALUE;
	private static int min=Integer.MAX_VALUE;
	//private static Scanner in=new Scanner(System.in);
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void Solve(int n,int q){
	}
 
	public static void main(String[] args) throws IOException {
		try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Sameer Raj\\Desktop\\p022_names.txt"));
            String str;
            str = in.readLine();
            String ar[]=str.split(",");
            Arrays.sort(ar);
            long total=0,sum;
            for(int i=0;i<ar.length;i++){
            	sum=0;
            	for(int j=1;j<ar[i].length()-1;j++){
            		sum=sum+ar[i].charAt(j)-65+1;
            	}
            	total=total+(sum*(i+1));
            }
            System.out.println(total);
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
	}
}

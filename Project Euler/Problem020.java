import java.io.*;
import java.util.*;

public class Solution {
    
    public static void BigFactorial(int n,ArrayList<Integer> ar){
        int mult,carriage=0;
        ar.add(1);
        for(int i=2;i<=n;i++){
            for(int c=0;c<ar.size();c++){
                mult=(ar.get(c)*i)+carriage;
             
                ar.set(c,mult%10);
                carriage=mult/10;
        }
            while(carriage!=0){
                ar.add(carriage%10);
                carriage=carriage/10;
            }
     }
       
  }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<Integer> ar=new ArrayList();
        long sum;
        int t=in.nextInt();
        for(int k=0;k<t;k++){
            sum=0;
            int n=in.nextInt();
            BigFactorial(n,ar);
            for(int i=0;i<ar.size();i++)
                sum=sum+ar.get(i);
            System.out.println(sum);
            ar.clear();
        }
    }
}

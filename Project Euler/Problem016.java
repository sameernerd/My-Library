import java.io.*;
import java.util.*;

public class Solution {
       public static void Big(int n){
           ArrayList<Integer> ar=new ArrayList();
        int mult,carriage=0;
        ar.add(2);
        for(int i=0;i<n-1;i++){
            for(int c=0;c<ar.size();c++){
                mult=(ar.get(c)*2)+carriage;
             
                ar.set(c,mult%10);
                carriage=mult/10;
        }
            while(carriage!=0){
                ar.add(carriage%10);
                carriage=carriage/10;
            }
     }
           long sum=0;
       for(int i=0;i<ar.size();i++)
           sum=sum+ar.get(i);
           System.out.println(sum);
  }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int k=0;k<t;k++){
            int n=in.nextInt();
            Big(n);
        }
    }
}

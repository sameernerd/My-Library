//My Code(6/10)

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static boolean isPrime(long n){
        boolean val=true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){val=false;break;}
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long smallestFactor,largestFactor;
        long result; //It will store result
       int c;
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            c=0;
            smallestFactor=1;largestFactor=1;result=0;
            if(isPrime(n)){
                System.out.println(n);
            }
            else{
            for(long i=2;i<n/2;i++){
                if(n%i==0){
                    c++;
                    smallestFactor=i;
                    largestFactor=n/smallestFactor;
                    if(isPrime(largestFactor)){
                        result=largestFactor;
                        break;
                    }
                }
            }
            if(c==0&&isPrime(n))System.out.println(n);
            else System.out.println(result);
            }
        }
        }
    }

//Editorial Code(10/10)
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long p=0;
            for(long i=2;i*i<=n;i++){
                while(n%i==0){
                    p=i;
                    n/=i;
                }
            }
            if(n>1)System.out.println(n);
            else System.out.println(p);
        }
    }
}

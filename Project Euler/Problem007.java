//We can easily make this code more efficient by using Sieve of Erathosthenes here I used it but in not so good form.
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
     ArrayList<Integer> PrimeArray=new ArrayList();
		for(int i=2;i<=107000;i++)
			PrimeArray.add(i);
		
		//Removing all the even number except 2  i,0=2
		for(int i=1;i<PrimeArray.size();i++){
			if(PrimeArray.get(i)%2==0)PrimeArray.set(i,-1);
		}
		
		for(int i=1;i<PrimeArray.size();i++){
			if(PrimeArray.get(i)==-1)continue;
			for(int j=i+1;j<PrimeArray.size();j++){
				 if(PrimeArray.get(j)%PrimeArray.get(i)==0)PrimeArray.set(j,-1);
			}
		}
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int count=0,get=0;
	       while(count<PrimeArray.size()){	
	    	if(PrimeArray.get(count)!=-1)get++;
	    	if(get==m){System.out.println(PrimeArray.get(count));break;}
	    	count++;
	    }

        }
    }
}

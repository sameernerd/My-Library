//Lattice Path Dynamic Solution

import java.io.*;
import java.util.*;

public class Solution {
    static private long MAX=1000000007;
    public static long solve(int r,int c){
        long ar[][]=new long[r+1][c+1];
        ar[0][0]=1;
        for(int i=0;i<=r;i++){
            for(int j=0;j<=c;j++){
                if(i!=0&&j!=0)ar[i][j]=(ar[i-1][j]+ar[i][j-1])%MAX;
                else if(i==0&&j!=0)ar[i][j]=ar[i][j-1]%MAX;
                else if(i!=0&&j==0)ar[i][j]=ar[i-1][j]%MAX; 
            }
        }
        
        return (ar[r][c]);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int k=0;k<t;k++){
            int n=in.nextInt();
            int m=in.nextInt();
            System.out.println(solve(n,m));
        }
    }
}

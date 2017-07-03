//Brute Forcing
import java.util.*;

public class Solution {
    
    public static long solve(int ar[][]){
        int n=20;
        long max=0,temp=0;
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(j+3<n){
                    temp=ar[i][j]*ar[i][j+1]*ar[i][j+2]*ar[i][j+3];
                    if(temp>max)max=temp;
                }
                //calculating bottom
                if(i+3<n){
                    temp=ar[i][j]*ar[i+1][j]*ar[i+2][j]*ar[i+3][j];
                    if(temp>max)max=temp;
                }
                 if(i+3<n&&j+3<n){
                     temp=ar[i][j]*ar[i+1][j+1]*ar[i+2][j+2]*ar[i+3][j+3];
                    if(temp>max)max=temp;
                 }
                if(i+3<n&&j>=3){
                     temp=ar[i][j]*ar[i+1][j-1]*ar[i+2][j-2]*ar[i+3][j-3];
                     if(temp>max)max=temp;
                 }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.print(solve(grid));
    }
}

package org.example;

import java.util.Arrays;

public class maxDistance {

    public int maxDistance(int position [] , int m) {
        Arrays.sort(position);
        int l=1;
        int ans=0;
        int r=position[position.length-1]-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(check(position,m,mid)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }

    private boolean check(int[] position, int m, int mid) {
    int curr=position[0];
    int count=1;
    int force=mid;
    for(int i=1;i<position.length;i++){
        if(position[i]-curr>=force){
            count++;
            curr=position[i];
        }
    }
    return count>=m;
    }
}

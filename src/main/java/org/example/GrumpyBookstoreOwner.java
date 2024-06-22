package org.example;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int max=0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]!=1){
                max+=customers[i];
            }
        }
        int x=0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                x += customers[i];
            }
        }

        int y=x;
        for (int i=minutes ;i<grumpy.length;i++){
            if(grumpy[i]==1){
                x+=customers[i];
            }
            if(grumpy[i-minutes]==1)
                x-=customers[i-minutes];
            y=Math.max(x,y);
        }

        return max+y;
    }
}

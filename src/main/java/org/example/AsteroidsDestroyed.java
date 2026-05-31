package org.example;

import java.util.Arrays;

public class AsteroidsDestroyed {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long z=mass;
        for (int x:asteroids){
            if (z>=x){
                z+=x;
            }else{
                return false;
            }
        }
        return true;
    }
}

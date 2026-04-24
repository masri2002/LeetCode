package org.example;

public class FurthestDistanceFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
      String fullLeft = moves.replaceAll("_","L");
      String fullRight=moves.replaceAll("_","R");
      int resR=0;
      for (char c : fullRight.toCharArray()){
          if (c=='R'){
              resR++;
          }else{
              resR--;
          }
      }
      int resL=0;
      for (char c: fullLeft.toCharArray()){
          if (c=='L')resL++;
          else resL--;
      }
      return Math.max(resL,resR);
    }

//    public int furthestDistanceFromOrigin(String moves) { optimal sou
//        int cntR=0;
//        int cntL=0;
//        for (char c : moves.toCharArray()){
//            if(c=='R'){
//                cntR++;
//                cntL--;
//            }if (c=='L'){
//                cntR--;
//                cntL++;
//            }else if(c=='_'){
//                cntR++;
//                cntL++;
//            }
//        }
//        return Math.max(cntR,cntL);
//    }

    public static void main(String[] args) {
        FurthestDistanceFromOrigin distanceFromOrigin  =  new FurthestDistanceFromOrigin();
        System.out.println(distanceFromOrigin.furthestDistanceFromOrigin("L_RL__R"));
    }
}

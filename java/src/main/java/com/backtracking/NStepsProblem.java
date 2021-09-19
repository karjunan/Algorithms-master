package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NStepsProblem {


    public static void main(String [] ar) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <= 4; i++) {
            list.add(-1);
        }
        int result = nSteps(4,list,new ArrayList<>(),new ArrayList<>());

        System.out.println("Result >> " + result);
    }

    public static int nSteps(int steps,List<Integer> list,
                             List<Integer> aList, List<List<Integer>> fList) {

        if(steps <= -1) {
            return 0;
        } else if(steps == 0) {
            return 1;
        }


        if( list != null  && list.get(steps) != -1 ) {
            return list.get(steps);
        }

        int v1 = nSteps(steps-1,list,aList,fList);
        aList.add(steps-v1);
        int v2 =  nSteps(steps-2,list,aList,fList);
        aList.add(steps-v2);
        list.add(steps,v1+v2);
        return v1+v2;

    }
}

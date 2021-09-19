package com.backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

        public static void main(String [] ar) {

            int [] arr = {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412 };


            ArrayList<Integer> list = Arrays.stream(arr).mapToObj(v -> Integer.valueOf(v)).collect(Collectors.toCollection(ArrayList::new));

            List<BigInteger> ls = new ArrayList<>();
            largestNumber(list,new ArrayList<>(),ls);
            System.out.println(ls.size());
            BigInteger temp = new BigInteger("0");
            for( int i = 0 ; i < ls.size(); i++) {
                int comparevalue = ls.get(i).compareTo(temp);
                // print result
                if (comparevalue == 1) {
                    temp = ls.get(i);
                }
            }

            System.out.println("Result >>" + temp.toString() );


        }


        public static void largestNumber( ArrayList<Integer> in, ArrayList<String> out, List<BigInteger> result ) {


            if(in.isEmpty()) {
                // System.out.println(out);
                String str = out.stream().collect(Collectors.joining());
                // System.out.println(str);
                BigInteger rs = new BigInteger(str);
                result.add(rs);
                return;
            }



            for( int i = 0 ; i < in.size(); i++) {
                Integer inVal = in.get(i);
                String val = Integer.toString(inVal);
                out.add(val);
                in.remove(inVal);

                largestNumber(in,out,result);
                String r = out.remove(out.size()-1);
                in.add(i,Integer.parseInt(r));
            }
            return;
        }


}

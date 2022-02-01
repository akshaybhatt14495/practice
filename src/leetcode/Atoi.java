package leetcode;

import java.util.Arrays;
import java.util.List;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
    }
    public static int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;}
        int pointer=0;
        int symbol=1;
        while(pointer<s.length()&& s.charAt(pointer)==' ') pointer++;
        if (pointer >=s.length()) {
            return 0;
        }

        //check for symbol

        if (s.charAt(pointer)=='-') {
            symbol=-1;
            pointer++;
        }else if (s.charAt(pointer) == '+') {
            pointer++;
        }
        //next should be integer value for sure.

        while(pointer<s.length() && s.charAt(pointer) =='0') pointer++;




        int end = pointer;

        while (end<s.length()-1 &&  (s.charAt(end) >='0' && s.charAt(end)<='9')) {
            end++;
        }
        if (pointer >=s.length()) {
            return 0;
        }
        while (end >=pointer && !(s.charAt(end) >='0' && s.charAt(end) <='9')) end--;

        long multiplier=1;
        long value=0;
        int []nums = new int[]{1,2,3};

        for (int i=end; i>=pointer; i--) {
            int remainder=0;
            switch(s.charAt(i))
            {
                case '1': {
                    remainder=1;
                    break;
                }
                case '2': remainder=2;
                    break;case '3': remainder=3;
                break;case '4': remainder=4;
                break;case '5': remainder=5;
                break;case '6': remainder=6;
                break;case '7': remainder=7;
                break;case '8': remainder=8;
                break;case '9': remainder=9;
                break;case '0': remainder=0;
                break; default: return 0;
            }


            value = value + multiplier*remainder;


            if (value*symbol > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (value*symbol < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }


            if (multiplier*symbol > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (multiplier*symbol < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            multiplier=multiplier*10;


        }

        return (int)(symbol*value);
    }
}

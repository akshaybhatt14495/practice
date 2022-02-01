package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StringToIpCombinations {
    public static void main(String[] args) {
        System.out.println(new StringToIpCombinations().restoreIpAddresses("25525511135"));
    }
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        restoreIpAddress(s, "", 0, 0, result);
        return result;
    }

    void restoreIpAddress(String s, String ip, int idx,int count, List<String> result) {
        if (count ==4 && idx ==s.length()) {
            result.add(ip.substring(0, ip.length()-1));
            return;
        }

        if ((count ==4 && idx < s.length()) || (idx ==s.length() && count <4)) {
            return;
        }

        if (s.charAt(idx)== '0') {
            restoreIpAddress(s, ip+"0.", idx+1, count+1, result);
            return;
        }

        int data=0;
        int pow=10;
        for (int i=idx; i<s.length();i++) {
            int x= Integer.parseInt(String.valueOf(s.charAt(i)));

            //System.out.println(x);
            data=data*pow + x;

            if (data<=255) {
                restoreIpAddress(s, ip+ data +".", i+1, count+1, result);
            } else {
                return;
            }

        }
    }
}
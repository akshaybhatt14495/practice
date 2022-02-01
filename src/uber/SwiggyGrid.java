package uber;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class SwiggyGrid {
    //https://github.com/kaushal02/interview-coding-problems/blob/master/prisonBreak.cpp
    long  prison(int n, int m, List<Integer> hor, List<Integer> ver) {
        boolean [] xs = new boolean[n+1];
        boolean [] ys = new boolean[m+1];

        for (int h : hor) xs[h] = true;
        for (int v : ver) ys[v] = true;
        int xm = 0, ym = 0;
        for (int i = 1, j = 0; i <= n; i++) {
            if (!xs[i]) j = 0;
		else xm = Math.max(xm, ++j);
        }
        for (int i = 1, j = 0; i <= m; i++) {
            if (! ys[i]) j = 0;
		    else ym =  Math.max(ym, ++j);
        }
        return (xm + 1) * (ym + 1);
    }

    public static void main(String[] args) {
        System.out.println("test");
    }

    //https://www.youtube.com/watch?v=8MdutrMAwY4
    long minimumOneBitOperations(long n)
    {
        if (n==0) return 0;
        String str = Long.toBinaryString(n);
        int i = 0;
        while (i<str.length() && str.charAt(i)=='0')
            i++;
        str = str.substring(i);

        long lastDigit = 0;
        long ret = 0;
        for (i=0; i<str.length(); i++)
        {
            // x ^ lastDigit = str[i]
            long x;
            if (str.charAt(i)=='1')
                x = lastDigit==1 ? 0 : 1;
            else
                x = lastDigit==1 ? 1 : 0;
            lastDigit = x;
            ret = ret*2+x;
        }

        return ret;
    }
}

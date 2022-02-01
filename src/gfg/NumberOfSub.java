package gfg;

public class NumberOfSub {
    public static void main(String[] args) {
        System.out.println(substrCount("aba", 2));;
    }
    static long substrCount (String S, int k) {
        //sliding window
        int dist[] = new int[26];
        int l=0, r=0;
        long total = 0;
        int count = 0;
        while (l <S.length() && r < S.length() && l <=r) {
            if (count > k) {
                dist[S.charAt(l) - 'a']--;
                l++;
            } else if  (count < k) {
                dist[S.charAt(r)- 'a']++;
                r++;
            } else if (count == k) {
                System.out.println(S.substring(l, r+1));
               // int subLength = r-l;
                total ++;
                dist[S.charAt(l) - 'a']--;
                l++;
            }
            count  = getCount(dist);
        }

        while (l <S.length()) {
            if (count < k) {
                return total;
            }
            if (count > k) {
                dist[S.charAt(l)- 'a']--;
                l++;
            }  else if (count == k) {
                //int subLength = S.length() -l -1;
                System.out.println(S.substring(l, r));
                total ++;
                dist[S.charAt(l) - 'a']--;
                l++;
            }
            count  = getCount(dist);
        }

        return total;
    }

    static int getCount(int []dist) {
        int count = 0;
        for (int i=0; i< dist.length; i++) {
            if (dist[i]>0) {
                count++;
            }
        }
        return count;
    }
}

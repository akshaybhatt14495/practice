package hackerrank;

public class AlphaCombinations {
    public static void main(String[] args) {
        System.out.println(calculatePossibleCombinations("24154202616"));
    }

    public static long calculatePossibleCombinations(String str) {
        System.out.println(str);
        long dp[] = new long[str.length()];
        for (int i=0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return calculatePossibleCombinations(str, 0, dp);
    }

    public static long calculatePossibleCombinations(String str, int i, long []dp) {
        String sunString = str.substring(i);
        if (dp[i] >=0) {
            return dp[i];
        }
        if (i==str.length()-1) {
            if (str.charAt(i) == '0') {
                dp[i] = 0;
                return 0;
            }
            dp[i] = 1;
            return 1;
        }

        if (i == str.length()-2) {
            if (str.charAt(i) == '0') {
                dp[i] = 0;
                return 0;
            }
            int merge = Integer.parseInt(String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)));
            if (merge <=26) {
                dp[i] = 2;
                return 2;
            } else {
                dp[i] = 1;
                return 1;
            }
        }
        long count = calculatePossibleCombinations(str, i+1, dp);
        int merge = Integer.parseInt(String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i+1)));
        if (merge <=26) {
            count += calculatePossibleCombinations(str, i+2, dp);
        }
        dp[i] = count;
        return count;
    }
}

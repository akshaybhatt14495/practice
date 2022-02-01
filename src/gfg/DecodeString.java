package gfg;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(count("3[a2[bd]g4[ef]h]")); //bcaca * 3
        //3[abbbab]
        //abbbababbbababbbab
    }
    public static String count(String str) {
        int i=0;
        String result = "";
        int bracketCounter = 0;
        boolean first = false;
        String middle = "";
        int counter = 0;
        while (i< str.length()) {
            int j=i;
            while (i < str.length() && str.charAt(i) >='a' && str.charAt(i) <='z') {
                i++;
            }
            //check for characters
            result +=str.substring(j, i);
            String middleWithFre = "";
            j=i;
            while (i < str.length() && str.charAt(i) !='[') {
                i++;
            }
            if (i==j) {
                return result;
            }
            int freq = Integer.parseInt(str.substring(j, i));

            if (str.charAt(i)=='[') {
                bracketCounter = 1;
                String internal = "";
                i++;
                j=i;
                while (i< str.length()) {
                    if (str.charAt(i)=='[') bracketCounter++;
                    if (str.charAt(i)==']') bracketCounter--;
                    if (bracketCounter==0) {
                        middle = count(str.substring(j,i));
                        while (freq>0) {
                            result += middle;
                            freq--;
                        }
                        i++;
                        break;
                    }
                    i++;
                }
            }
        }
        return result;
    }
}

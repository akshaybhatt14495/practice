package gfg;

public class RearrangeString {
    public static void main(String[] args) {
        System.out.println(arrangeString("AC2BEW3"));
    }
    public static String arrangeString(String s)
    {

        int []alCount=new int[26];

        int count =0;
        for (char x:s.toCharArray()){

            if (x >='A' && x <='Z') {
                alCount[x-'A']++;
            } else {
                count +=Integer.parseInt(String.valueOf(x));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;  i< alCount.length; i++) {
            for (int j=0; j< alCount[i]; j++) {
                sb.append((char)('A'+i));
            }
        }
        sb.append(count);
        return sb.toString();
    }
}
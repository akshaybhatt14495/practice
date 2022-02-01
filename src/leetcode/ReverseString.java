package leetcode;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
    public String reverseOnlyLetters(String s) {

        char[] str=s.toCharArray();

        int i=0;
        int j=s.length()-1;

        while(i<=j) {

            if ((str[i]<'a' && str[i]>'z')|| (str[i]<'A' && str[i]>'Z')) {
                i++;
                continue;
            }
            if((str[j]<'a' && str[j]>'z')|| (str[j]<'A' && str[j]>'Z')){

                j--;
                continue;
            }
            char temp=str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;
        }

        return new String(str);

    }
}

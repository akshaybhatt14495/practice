package hackerrank;

import java.util.Stack;

public class XmlParser {
    public static void main(String[] args) {
        //System.out.println(validate_xml("text"));
        //System.out.println(validate_xml("text<a>more text</a>"));
//        System.out.println(validate_xml("text<a>"));
//        System.out.println(validate_xml("<invalid<>text</invalid>"));
//        System.out.println(validate_xml("<a><b></a></b>"));
        System.out.println(validate_xml(" <></>"));


    }
    public static String validate_xml(String xml) {
        Stack<String> st = new Stack<>();
        for (int i=0; i< xml.length();) {
            //tag opening
            if (xml.charAt(i) == '<') {
                //  close tag
                int  prefix = i;
                String tag= "<"; i++;
                while (i < xml.length() && xml.charAt(i) != '>') {
                    if (xml.charAt(i) == '<') {
                        return "parse error";
                    }
                    tag +=xml.charAt(i);
                    i++;
                }
                if (i == xml.length()) {
                    return "parse error";
                }
                tag +=xml.charAt(i);
                if (tag.length() <=2) {
                    return "parse error";
                }
                //open or closing tag<a> or </a>
                if (xml.charAt(prefix+1) == '/') {
                    //closing tag
                    if (st.empty()) {
                        return "missing closing tag for <a>";
                    }
                    String openTag = st.peek();
                    if (openTag.length()+1 != tag.length()) {
                        return "encountered closing tag without matching open tag for " + tag;
                    }
                    if (openTag.substring(1, openTag.length()-1).equals(tag.substring(2, tag.length()-1))) {
                        //looks good , then pop
                        st.pop();
                        i++;
                        continue;
                    } else {
                        return "encountered closing tag without matching open tag for " + tag;
                    }

                } else {
                    //opening tag
                    st.push(tag);
                    i++;
                    continue;
                }
            }

            //tag closing
            if (xml.charAt(i) == '>') {
                return "parse error";
            }
            i++;
        }
        if (st.empty()) {
            return "valid";
        } else {
            return "missing closing tag for " + st.peek();
        }
    }
}

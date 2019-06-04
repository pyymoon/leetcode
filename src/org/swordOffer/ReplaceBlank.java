package org.swordOffer;

public class ReplaceBlank {
    public String replaceSpace1(StringBuffer str){
        if(str==null){return null;}
        int len = str.length();
        for(int old=len-1;old>=0;old--){
            if(str.charAt(old) == ' '){
                str.replace(old,old+1,"%20");
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        ReplaceBlank replaceBlank = new ReplaceBlank();
        StringBuffer str = new StringBuffer("hello world");
        String str1;
        str1 = replaceBlank.replaceSpace1(str);
        System.out.println(str1);
    }
}

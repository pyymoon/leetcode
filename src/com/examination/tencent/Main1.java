package com.examination.tencent;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    private List<Integer> findZhongKH(StringBuffer string) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        for (int j = 0; j < string.length(); j++) {
            if (string.charAt(j) == '[') {
                start = j;
            }
            if (string.charAt(j) == ']') {
                list.add(start);
                list.add(j);
                break;
            }
        }
        return list;
    }

    private void replace(int start, int end, StringBuffer stringBuffer) {
        String number = "";
        String string = "";
        for (int i = start + 1; i <= end; i++) {
            if (stringBuffer.charAt(i) == '|') {
                for (int j = i + 1; j < end; j++) {
                    string += stringBuffer.charAt(j);
                }
                break;
            }
            number += stringBuffer.charAt(i);
        }
        String replaceString = "";
        for (int i = 0; i < Integer.valueOf(number); i++) {
            replaceString += string;
        }
        stringBuffer.replace(start, end + 1, replaceString);
    }

    public String replaceAll(String string) {
        StringBuffer sb = new StringBuffer(string);
        List<Integer> indexList = findZhongKH(sb);
        while (indexList.size() != 0) {
            int start = indexList.get(0);
            int end = indexList.get(1);
            replace(start, end, sb);
            indexList = findZhongKH(sb);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        Main1 main = new Main1();
        string = main.replaceAll(string);
        System.out.println(string);
    }
}

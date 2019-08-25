package com.examination.byteDance;

import java.util.Scanner;

public class Main {
    public String decodeFirst(String S, int N, int K) {
        StringBuffer sb = new StringBuffer();
        StringBuffer ss = new StringBuffer();
        sb.append(S.charAt(0));
        for (int i = 1; i <= K - 1; i++) {
            sb.append(S.charAt(i) ^ S.charAt(i - 1));
        }
        ss.append(S.charAt(K + N - 2));
        for (int i = K + N - 3; i >= 2 * K - 1; i--) {
            ss.append(S.charAt(i) ^ S.charAt(i + 1));
        }
        for (int i = ss.length() - 1; i >= 0; i--) {
            sb.append(ss.charAt(i));
        }
        return sb.toString();
    }

    public String decodeSecode(String S, int N, int K) {
        StringBuffer sb = new StringBuffer();
        StringBuffer ss = new StringBuffer();
        sb.append(S.charAt(0));
        for (int i = 1; i <= K - 1; i++) {
            sb.append(S.charAt(i) ^ S.charAt(i - 1));
        }
        ss.append(S.charAt(K + N - 2));
        for (int i = K + N - 3; i > N - 2; i--) {
            ss.append(S.charAt(i) ^ S.charAt(i + 1));
        }
        if (N > 2 * K) {
            for (int i = K; i < N - K; i++) {
                int c = sb.charAt(0) ^ sb.charAt(1);
                for (int j = 2; j < sb.length(); j++) {
                    c = sb.charAt(j) ^ c;
                }
                sb.insert(i, c);
            }
        }
        for (int i = ss.length() - 1; i >= 0; i--) {
            sb.append(ss.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String S = sc.next();
        Main main = new Main();
        S = main.decodeSecode(S, N, K);
        System.out.println(S);
    }
}

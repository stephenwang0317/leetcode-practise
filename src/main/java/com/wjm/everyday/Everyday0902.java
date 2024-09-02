package com.wjm.everyday;

public class Everyday0902 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int l = 0, lSumT = 0, rSumT = 0, rSumF = 0, lSumF = 0;
        int max = 0;
        for (int r = 0; r < answerKey.length(); r++) {
            rSumT += (answerKey.charAt(r) == 'T' ? 1 : 0);
            rSumF += (answerKey.charAt(r) == 'F' ? 1 : 0);

            while (rSumT - lSumT > k && rSumF - lSumF > k) {
                lSumT += (answerKey.charAt(l) == 'T' ? 1 : 0);
                lSumF += (answerKey.charAt(l) == 'F' ? 1 : 0);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Everyday0902 q = new Everyday0902();
        int i = q.maxConsecutiveAnswers("TFFT", 1);
        System.out.println(i);
    }
}

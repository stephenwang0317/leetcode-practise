package com.wjm.autumn;

/**
 * 一位老师正在出一场由 n 道判断题构成的考试，
 * 每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
 * 老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。
 * 除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 */
public class Question035 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max = Integer.MIN_VALUE;
        int lSum = 0, rSum = 0, l = 0;
        for (int r = 0; r < answerKey.length(); r++) {
            rSum += (answerKey.charAt(r) == 'T' ? 1 : 0);
            while (rSum - lSum > k) {
                lSum += (answerKey.charAt(l) == 'T' ? 1 : 0);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        lSum = 0;
        rSum = 0;
        l = 0;
        for (int r = 0; r < answerKey.length(); r++) {
            rSum += (answerKey.charAt(r) == 'F' ? 1 : 0);
            while (rSum - lSum > k) {
                lSum += (answerKey.charAt(l) == 'F' ? 1 : 0);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Question035 q = new Question035();
        int i = q.maxConsecutiveAnswers("TFFT", 1);
        System.out.println(i);
    }
}

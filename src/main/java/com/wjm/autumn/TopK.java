package com.wjm.autumn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 */
public class TopK {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) return new int[0];
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            q.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > q.peek()) continue;
            else {
                q.poll();
                q.offer(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll();
        }
        return ans;
    }

    public int[] smallestK2(int[] arr, int k) {
        qSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void qSort(int[] nums, int l, int r, int k) {
        if (l >= r) return;
        int pivot = nums[l];
        int oL = l, oR = r;
        while (l < r) {
            while (l < r && nums[r] > pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        if (l > k) {
            qSort(nums, oL, l - 1, k);
        } else {
            qSort(nums, oL, l - 1, k);
            qSort(nums, l + 1, oR, k);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 7, 2, 4, 6, 8};
        TopK k = new TopK();
        int[] ints1 = k.smallestK2(ints, 4);
        System.out.println(Arrays.toString(ints1));
    }
}

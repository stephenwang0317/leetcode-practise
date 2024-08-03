package com.wjm.autumn

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 */

fun maxSubArray(nums: IntArray): Int {
    var max = nums[0]
    var cur = nums[0]
    for (i in 1 until nums.size) {
        val num = nums[i]
        cur = Math.max(num, num + cur)
        max = Math.max(cur, max)
    }
    return max
}

fun main() {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    print(maxSubArray(nums))
}
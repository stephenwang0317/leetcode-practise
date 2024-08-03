package com.wjm.autumn

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
class Question010 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val match = target - nums[i]
            val index = map.getOrDefault(match, -1)
            if (index != -1 && index != i) {
                return intArrayOf(i, index)
            } else {
                map.put(nums[i], i)
            }
        }
        return intArrayOf(-1, -1)
    }
}
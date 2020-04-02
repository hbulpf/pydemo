/**
 * 题目：给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 暴力解法：写一个循环，然后里边判断是否到了中位数的位置，到了就返回结果。
 * 对于数组长度之和奇数和偶数时的情况要分别处理
 * 复杂度：O(m+n)
 * 题解:
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * 
 * 待优化
 * */

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int len1 = nums1.size();
        int len2 = nums2.size();
        int mode =  (len1 + len2) % 2 == 0 ? 0 : 1;
        int loc = (len1 + len2) / 2 ;
        int p1 = 0, p2 = 0, p = 0;
        double val = 0;
        while(p1 < len1 || p2 < len2)
        {
            if(p1 < len1 && p2 < len2)
            {
                if(nums1[p1] < nums2[p2])
                {
                    val = nums1[p1];
                    p1++;
                }
                else
                {
                    val = nums2[p2];
                    p2++;
                }
            }
            else if(p1 < len1)
            {
                val = nums1[p1];
                p1++;
            }
            else
            {
                val = nums2[p2];
                p2++;
            }

            if(loc == p && mode == 1)
            {
                break;
            }
            else if(loc == p+1 && mode == 0)
            {
                if(p1 < len1 && p2 < len2)
                    val += (nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2]);
                else if(p1 < len1)
                    val += nums1[p1];
                else
                    val += nums2[p2];
                val /= 2;
                break;
            }
            else
            {
                p++;
            }
        }
        return val;

    }
};
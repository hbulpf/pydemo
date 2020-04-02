/**
 * 题目：最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * case：
 * input:babad
 * output:bab
 * 
 * 解法：动态规划
 * 
 * 定义P(i,j)为字符串子串从si到sj是否为回文串
 * 若是：
 * P(i,j) = true
 * 否则
 * P(i,j) = false
 * 
 * 因此满足下列公式：
 * P(i,j) = (P(i+1,j-1) and sj == sj)
 * 
 * 初始化时，先初始化一个字符和两个字符（如：aa）是回文字符串的情况，然后再循环计算
 * 三个、四个字符串乃至最长的回文的情况
 **/
#include<string>
class Solution {
public:
    string longestPalindrome(string s) {
        int slen = s.size();
        bool* dp = new bool[slen*slen];
        int i=0,j=0;
        int maxlen = 0;
        string res;
        // 单个字符
        for(int i=0;i<slen;i++)
            for(int j=i;j<slen;j++)
            {
                if(i==j){
                    dp[i*slen+j] = true;
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        res = s.substr(i,j-i+1);
                    }
                }
                else
                    dp[i*slen+j] = false;
            }
        //叠字
        for(int i=0;i<slen-1;i++)
            if(s[i]==s[i+1]){
                dp[i*slen+i+1] = true;
                if(2>maxlen){
                    maxlen = 2;
                    res = s.substr(i,2);
                }
            }
        
        //其他
        for(int i=1;i<=slen-2;i++)
            for(int j=0;j<slen;j++)
            {
                if(j-1>=0 && j+i<slen && dp[j*slen+j+i-1] && s[j-1]==s[j+i])
                {
                    dp[(j-1)*slen+j+i] = true;
                    if(i+2>maxlen){
                        maxlen = i+2;
                        res = s.substr(j-1,i+2);
                    }
                }
            }
            
        
        return res;
    }
};
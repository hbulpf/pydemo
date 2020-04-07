/**
 * 题目：正则表达式匹配
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 解法：
 * 记字符串为s,匹配模式为p
 * 如果p[j] == '.'或者p[j] == s[i]:当前匹配成功
 * 如果p[j] == '*'则：
 *      如果p[j-1]=='.'或者p[j-1]==s[j],则p[j-1]p[j]这个模式可以以使用1到无数次，匹配成功
 *      如果p[j-1]=='.'和p[j-1]==s[i]都不成立，但可以使用p[j-1]p[j]这个模式串0次，匹配成功
 * 除了以上情况，均匹配不成功
 * 
 * 参考：https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-he-di-gui-bi-jiao-fang-fa-shi-xia/
 **/

class Solution {
public:
    // 递归解法
    bool isMatch_R(string s, string p) {
        if(p.empty())
            return s.empty();
        
        auto first_match = !s.empty() && (s[0] == p[0] || p[0] == '.');
        if(p.size() >= 2 && p[1] == '*')
            return isMatch_R(s,p.substr(2)) || (first_match && isMatch_R(s.substr(1),p));
        else
            return first_match && isMatch_R(s.substr(1),p.substr(1));
    }

    // 动态规划解法
    bool isMatch(string s, string p) {
        if(p.empty()) 
            return s.empty();   //如果pattern为空，但是s不为空；
        
        int m = s.size();
        int n = p.size();
        vector<vector<bool>> dp(m+1,vector<bool>(n+1,false));
        dp[0][0] = true;

        for(int i=1;i<=n;i++)
        {
            if(i-2 >= 0 && p[i-1] == '*' && p[i-2])
                dp[0][i] = dp[0][i-2];
        }

        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(s[i-1] == p[j-1] || p[j-1] == '.')
                    dp[i][j] = dp[i-1][j-1];
                if(p[j-1] == '*')
                {
                    if(j-2 >= 0)
                    {
                        bool one  = (p[j-2] == s[i-1] || p[j-2] == '.') && dp[i-1][j];
                        bool two = dp[i][j-2];
                        dp[i][j] = one || two; 
                    }
                }
            }
            return dp.back().back();
    }
};
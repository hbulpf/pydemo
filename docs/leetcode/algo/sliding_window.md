# 滑动窗口

滑动窗口很多时候都是在处理字符串相关的问题.

## 算法框架

```
void slidingWindow(string s, string t) {
    unordered_map<char, int> window;
    
    // right 为0或-1
    int left = 0, right = 0;
    while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置 ***/
        printf("window: [%d, %d)\n", left, right);
        
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = s[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
    }
}
```

## 典型题目

1. [力扣 3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)   
2. [力扣 567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)

## 参考

1. [labuladong 的算法小抄](https://labuladong.gitee.io/algo/1/11/)
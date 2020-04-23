/**
 * 题目：187.重复的DNA序列
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 * 示例：
 * 
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 * 题解：
 * 滑动窗口+hashmap：
 * 从索引0开始以窗口大小为10个字母，向后移动，每次用hashmap记录窗口中子序列的出现的次数
 * 
 **/ 
class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> res;
        unordered_map<string, int> m;
        const int K = 10;
        if(s.size() <= K)
            return res;
        
        for(int i = 0;i < s.size() - K + 1;i++){
            string tmp = s.substr(i,K);
            if(m.find(tmp) == m.end())
                m[tmp] = 1;
            else if(m[tmp] == 1){
                m[tmp]++;
                res.push_back(tmp);
            }
            else
                m[tmp]++;
                
        }
        return res;
    }
};
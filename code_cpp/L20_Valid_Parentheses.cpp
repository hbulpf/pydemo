
/**
 * 
 * 题目：有效括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * - 左括号必须用相同类型的右括号闭合。
 * - 左括号必须以正确的顺序闭合。
 * 
 * 示例：
 * 输入：()
 * 输出：true
 * 
 * 输入：(){}[]
 * 输出：true
 * 
 * 题解：
 * 使用一个stack去维护左括号的集合，一旦遇到左括号就压入stack，一旦遇到右括号，就比较栈顶与当前括号是否匹配。匹配的话，弹出，继续遍历。
 * 边界条件：
 * (1) ")))" 对于没有左括号的情况，因此在调用stack的栈顶元素时，先要判断stack是否为空
 * (2) 遍历完string后，如果stack不为空，那么说明还有“残留”的左括号没有被匹配
 * 
 **/
class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for (auto ch : s)
        {
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}')
            {
                if (ch == ')')
                {
                    if (st.empty() || st.top() != '(')
                        return false;
                }
                else if (ch == ']') {
                    if (st.empty() || st.top() != '[')
                        return false;
                }
                else if (ch == '}') {
                    if (st.empty() || st.top() != '{')
                        return false;
                }
                st.pop();
            }
            else {
                return false;
            }
        }
        return st.empty();
    }
};
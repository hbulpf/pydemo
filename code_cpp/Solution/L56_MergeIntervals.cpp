/**
 * 题目：合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 题解：
 * 1. 按照每个区间的起点大小进行排序，排序完后可以合并的区间一定是连续的
 * 2. 用双指针记录两个带判断是否合并的区间，若前一个区间的终点大于后一个区间的起点，说明两者可以合并
 * 否则不能合并，合并后的区间终点取两个区间终点的最大值
 * 3. 循环往后进行，若判断两个区间不能合并，需要将前指针自增，且将前指针指向后指针的空间，这一步是为
 * 了将前面合并完的原区间覆盖掉
 * 
 * 复杂度：O(nlogn)
 **/
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if(!intervals.size() || intervals.size()==1)
            return intervals;
        sort(intervals.begin(),intervals.end(),compare);
    
        int pos = 0;
        int i = 1;
        for(;i < intervals.size();i++){
            if(intervals[pos][1] > intervals[i][0]){
                intervals[pos][1] = max(intervals[pos][1],intervals[i][1]);
            }else{
                pos++;
                intervals[pos] = intervals[i];
            }
        }
        intervals.resize(pos+1);
        return intervals;
    }

    static bool compare(const vector<int> &v1,const vector<int> &v2){
        return v1[0] < v2[0];
    }
};
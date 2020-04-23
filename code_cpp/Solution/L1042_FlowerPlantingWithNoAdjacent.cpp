
/**
 * 1042. 不邻接植花
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 * 
 * 示例 1：
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 
 * 示例 2：
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 
 * 示例 3：
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * 
 * 题解：
 * 关键词：邻接表+set
 * 1.使用邻接表表示每个节点与其他节点的路径
 * 2.对于每一个节点，初始化一个set，包含元素{1,2,3,4}四种类型的花，
 * 枚举与当前节点连通的其他节点的话的同类，若有相同的从set中删去
 * 3.选取set中剩余的一个花的种类作为当前节点的颜色
 **/ 
class Solution {
public:
    // 邻接表
    vector<int> gardenNoAdj(int N, vector<vector<int>>& paths) {
        vector<vector<int>> G;
        vector<int> p;
        // 初始化
        for(int i=0;i<N;i++)
            G.push_back(p);
        
        for(int i=0;i<paths.size();i++)
        {
            G[paths[i][0]-1].push_back(paths[i][1]-1);
            G[paths[i][1]-1].push_back(paths[i][0]-1);
        }

        vector<int> res(N,0);
        for(int i=0;i<N;i++){
            set<int> color {1,2,3,4};
            for(int j=0;j<G[i].size();j++){
                color.erase(res[G[i][j]]);
            }
            res[i] = *(color.begin());
        }

        return res;
    }
};
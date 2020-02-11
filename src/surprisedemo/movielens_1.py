# 可以使用上面提到的各种推荐系统算法
from surprise import SVD
from surprise import Dataset
from surprise import evaluate, print_perf

# 默认载入movielens数据集
data = Dataset.load_builtin('ml-100k')
# k折交叉验证(k=3)
data.split(n_folds=3)
# 试一把SVD矩阵分解
algo = SVD()
# 在数据集上测试一下效果
perf = evaluate(algo, data, measures=['RMSE', 'MAE'])
#输出结果
print_perf(perf)
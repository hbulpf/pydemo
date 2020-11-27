import os

from surprise import Reader, SVD
from surprise import Dataset,evaluate,print_perf

# 载入自己的数据集方法
# 指定文件所在路径
file_path = os.path.expanduser(r'F:\src_py\data\ml-100k\u.data')
# 告诉文本阅读器，文本的格式是怎么样的
reader = Reader(line_format='user item rating timestamp', sep='\t')
# 加载数据
data = Dataset.load_from_file(file_path, reader=reader)
# 手动切分成5折(方便交叉验证)
data.split(n_folds=5)
# 试一把SVD矩阵分解
algo = SVD()
# 在数据集上测试一下效果
perf = evaluate(algo, data, measures=['RMSE', 'MAE'])
#输出结果
print_perf(perf)
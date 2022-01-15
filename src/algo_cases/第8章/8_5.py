class Solution(object):
    def __init__(self):
        self.time=0
    def move(self,n, a, b, c):
        if n == 1:
            self.print(n,a,c)
        else:
            self.move(n - 1, a, c, b)
            self.print(n, a, c)
            self.move(n - 1, b, a, c)
    def print(self,n,a,c):
        self.time += 1
        print(f'第{self.time}次操作：将第{n}个圆盘从{a}-->{c}')

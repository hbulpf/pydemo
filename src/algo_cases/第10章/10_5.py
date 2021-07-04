class Solution:
    def NQueens(self, n):
        self.re = []
        self.rec = [float("inf") for i in range(n)]
        self.dfs(n,0)
        return self.re
    def figure(self,n):
        output=[]
        for i in range(len(self.rec)):
            stri='.'*self.rec[i]+'Q'+'.'*(n-self.rec[i]-1)
            output.append(stri)
        self.re.append(output)
    def dfs(self, n, row):
        if row == n:
            self.figure(n)
        for col in range(n):
            if self.judge(row, col):
                self.rec[row]=col
                self.dfs(n, row + 1)
                self.rec[row] =float("inf")
    def judge(self, row, col):
        for i in range(len(self.rec)):
            if self.rec[i]-i==col-row or self.rec[i]+i==col+row or self.rec[i]==col:
                return False
        return True

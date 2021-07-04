class Solution:
    def searchword(self, table, word):
        def dfs(i,j,n):
            if n>=len(word):
                return True
            tmp=table[i][j]
            table[i][j]='None'
          for direct in directions:
                if i+direct[0]>=0 and i+direct[0]<len_x and j+direct[1]>=0 and j+direct[1]<len_y :
                    if table[i+direct[0]][j+direct[1]]==word[n]:
                        if dfs(i+direct[0],j+direct[1],n+1):
                            table[i][j]=tmp
                            return True
            table[i][j]=tmp
            return False
        len_x=len(table)
        len_y=len(table[0])
        directions=[[1,0],[-1,0],[0,1],[0,-1]]
        for i in range(len(table)):
            for j in range(len(table[0])):
                if table[i][j]==word[0]:
                    if dfs(i,j,1):
                        return True
        return False

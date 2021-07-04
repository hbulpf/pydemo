def longestPalindrome(s):
    right=left=0
    dp=[]
    for i in range(len(s)):
        dp.append([False]*len(s))
        dp[i][i]=True
    i=len(s)-2
    while(i>=0):#填充二维数组的过程
        j=i+1
        while(j<len(s)):
            dp[i][j]=s[i]==s[j] and (dp[i+1][j-1] or j-i==1)
            if(dp[i][j] and right-left<j-i):
                right=j
                left=i
            j+=1
        i-=1
    return s[left:right+1]

def longestPalindrome(s):
    if(len(s)<=1):return s
    i=minstart=0
    maxl=1
    while i <len(s):
        if(len(s)-i<maxl/2):#遍历之前先做判断，适当终止
            break
        l=r=i
        while(r<len(s)-1 and s[r]==s[r+1]):
            r+=1   
        while(r<len(s)-1 and l>0 and s[l-1]==s[r+1]):
            r,l=r+1,l-1
        if(r-l+1>=maxl):
            minstart,maxl=l,r-l+1
        i+=1
    return s[minstart:minstart+maxl]

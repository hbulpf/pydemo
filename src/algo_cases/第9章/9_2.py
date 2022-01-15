class Solution():
    def fakecoin(self,low,high,coins):
        sum1=sum2=0
        re=-1
        if low==high:
            return high
        if high-low==1:
            if coins[high]<coins[low]:
                return high
            else:
                return low
        if (high-low+1)%2==0:
            mid=int((high-low+1)/2)
            sum1=sum(coins[low:low+mid])
            sum2=sum(coins[low+mid:high+1])
            if sum1>sum2:
                re=self.fakecoin(low+mid,high,coins)
                return re
            elif sum1<sum2:
                re = self.fakecoin(low,low+mid-1, coins)
                return re
        elif (high-low+1)%2!=0:
            mid=int((high-low)/2)
            sum1=sum(coins[low:low+mid])
            sum2= sum(coins[low+mid+1:high+1])
            if sum1>sum2:
                re=self.fakecoin(low+mid+1,high,coins)
                return re
            elif sum1<sum2:
                re=self.fakecoin(low,low+mid-1,coins)
                return re
32              elif coins[low+mid]!=coins[low]:
33                  return low+mid
34          return re

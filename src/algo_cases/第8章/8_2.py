class Solution(object):
  def reversenum(self,num):
      print(num%10)
      if(num>10):
          self.reversenum(num/10)

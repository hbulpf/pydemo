class queue():
    def __init__(self):
        self.stack1=[]
        self.stack2=[]
    def push_(self,num):
        self.stack1.append(num)
    def pop_(self):
        if len(self.stack2)==0:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

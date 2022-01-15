def RescueBoats(self, people, weight):
    people.sort()
    left=0
    right=len(people)-1
    res=0
    while(left<=right):
        res+=1
        if(people[left]+people[right]<=weight):
            left+=1 
        right-=1
    return res

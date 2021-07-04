import heapq
def smallestk(nums,k):
    if(len(nums)<=k):return nums
    heap=[]
    for i in range(len(nums)):
        if(i<k):
            heap.append(nums[i])
        else:
            heapq.heapify(heap)
            if heap[0]<nums[i]:
                heapq.heapreplace(heap,nums[i])
    return heap

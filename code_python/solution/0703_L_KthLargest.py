class KthLargest:
    """
    维护一个最小堆，堆的元素个数为常量 k，
    新加入一个元素和堆顶比较，如果比堆顶元素小，丢弃，
    否则删除堆顶元素，插入新元素。
    """

    def __init__(self, k,nums):
        self.k = k
        self.minheap = []

        # 构建大小为 k 的小顶堆(O(k))
        for i in range(min(k, len(nums))):
            self.minheap.append(nums[i])
            self.sift_up(i)

        # 将多余的 nums 元素加入其中(O(nlog(t)))
        for num in nums[k:]:
            if num > self.minheap[0]:
                self.minheap[0] = num
                # 下沉新加入的节点以维护小顶堆
                self.sift_down(0, k - 1)

    def sift_up(self, new_idx):
        new_val = self.minheap[new_idx]
        # 循环比较新加入的节点以及其双亲节点以上浮新加入的节点
        while new_idx > 0 and new_val < self.minheap[(new_idx - 1) // 2]:
            self.minheap[new_idx] = self.minheap[(new_idx - 1) // 2]
            new_idx = (new_idx - 1) // 2
        self.minheap[new_idx] = new_val

    def sift_down(self, start, end):
        start_val = self.minheap[start]
        # 循环比较新加入的节点以及其双子节点以下沉新加入的节点
        while start * 2 + 1 <= end:
            child = start * 2 + 1
            # 找到双子节点中较小的一个节点
            if child + 1 <= end and self.minheap[child] > self.minheap[child + 1]:
                child += 1
            if start_val > self.minheap[child]:
                self.minheap[start] = self.minheap[child]
                start = child
            else:
                break
        self.minheap[start] = start_val

    def add(self, val):
        if len(self.minheap) < self.k:
            self.minheap.append(val)
            self.sift_up(len(self.minheap) - 1)
        elif self.minheap[0] < val:
            self.minheap[0] = val
            self.sift_down(0, self.k - 1)
        return self.minheap[0]



/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 题解：哈希表 + 双向链表
 * 1. 哈希表支持O(1)查找
 * 2. 双向链表支持增删O(1)复杂度
 * 3. 利用哈希表记录节点在双向链表中的位置
 * 4. 调用get的时候先查找key在哈希表中是否存在，存在则返回，同时将双向链表中该节点移动到表头
 * 5. 调用put时，先查找节点是否存在，存在要更新节点到表头，不存在则在表头插入节点，同时将更新map
 * 6. 使用unordered_map，其内部实现为哈希表
 * 
 **/
class LRUCache {
private:
    int cap;
    list<pair<int,int>> l;
    unordered_map<int,list<pair<int,int>>::iterator> umap; // unordered_map内部实现hashtable，支持O(1)查找

public:
    LRUCache(int capacity) {
        cap = capacity;
    }
    
    int get(int key) {
        auto iter = umap.find(key);
        if(iter == umap.end())
            return -1;
        int val = iter->second->second;
        // 重新插入表头
        put(key,val);
        return val;
    }
    
    void put(int key, int value) {
        auto iter = umap.find(key);
        if(iter != umap.end())
        {
            l.erase(iter->second);
        }
        // 公共操作，list头部插入节点，更新umap
        l.push_front(make_pair(key,value));
        umap[key] = l.begin();
        if(l.size() > cap)
        {
            int last = l.back().first;
            umap.erase(last);
            l.pop_back();
        }

    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
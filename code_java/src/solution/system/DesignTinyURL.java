package system;

public class DesignTinyURL {

    /**
     * 这题和#535. Encode and Decode TinyURL类似，不过这题更偏向于系统设计
     *
     * 1. How many unique identifiers possible? Will you run out of unique URLs?
     * 如果按6个字符计算，一共有62**6种可能，大概三百多亿，越到后面碰撞越来越多，可以通过增加字符数来解决
     *
     * 2. Should the identifier be increment or not? Which is easier to design? Pros and cons?
     * 不能，那样容易被破解，比如爬虫直接按ID递增的顺序一个个抓即可。
     *
     * 3. Mapping an identifier to an URL and its reversal - Does this problem ring a bell to you?
     *
     * 4. How do you store the URLs? Does a simple flat file database work?
     * key为short, value为url, 则总共空间(6 + 30) * 30G = 1080G，单机恐怕不够，而且容易形成
     * 单点故障。最好分散到多个机器上，一致性hash负载均衡，KV数据库，以短网址为key，长网址为value
     * 每个机器上有固定前缀，后面的序号依次递增即可
     *
     * 5. What is the bottleneck of the system? Is it read-heavy or write-heavy?
     * 读显然比写多，比如用户在微博分享了一个资源，以短链接的形式。很多用户访问这个链接，则读远大于写。
     * 所以要用cache，读写分离
     *
     * 6. Estimate the maximum number of URLs a single machine can store.
     *
     * 7. Estimate the maximum number of queries per second (QPS) for decoding a shortened URL in a single machine.
     *
     * 8. How would you scale the service? For example, a viral link which is shared in social media could result in a peak QPS at a moment's notice.
     * 
     *
     * 9. How could you handle redundancy? i,e, if a server is down, how could you ensure the service is still operational?
     * 一致性哈希，虚拟节点
     *
     *
     * 10. Keep URLs forever or prune, pros/cons? How we do pruning?
     *
     * 11. What API would you provide to a third-party developer?
     * encode, decode
     *
     * 12. If you can enable caching, what would you cache and what's the expiry time?
     * KV db, key为short url，value为long url
     *
     *
     * 13, 如何防攻击？假如有人大量发相同的url耗光
     * 限制IP；一台KV服务器做缓存，key为long url，value为短url，如果缓存中有直接返回，cache是LRU的
     *
     *
     */


    /**
     * 可参考https://segmentfault.com/a/1190000006140476
     */
}

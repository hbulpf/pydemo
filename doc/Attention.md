一，数组相关的要考虑边界条件，包括数组为空，涉及INT_MAX/INT_MIN的情况
越界的问题，如数组，或s.charAt
<br/>

二，用HashSet或HashMap要考虑的问题是可能会相同键值的情况被覆盖了，典型的是
https://leetcode.com/problems/contains-duplicate-ii/
这个不能用HashSet，除非能解决这个问题
<br/>

三，涉及子数组的问题通常是动态规划，比如子数组最大乘积，最大和，最大什么序列之类的
<br/>

四，关于数组当有时候从前往后不行的时候，不妨考虑是否可以从后往前。
<br/>

五，限制次数为两次的，通常是以当前为分割线，前面和后面分别单独处理，最后合起来。或者数组从前往后一次，从后往前一次，两次结果合起来
<br/>

六，ArrayList不要随便用set，即使指定了初始capacity，但是size仍然为0。
<br/>

七，对于二分法，一定要注意left等于mid的情况，可能永远死循环，也可能返回错误的结果
<br/>

八，要注意运算符优先级，典型的是>>优先级是低于+-的
<br/>

九，关于java的binarySearch函数，返回值，如果存在该数，则返回该数的索引，否则返回插入点加1再取负，比如比所有数都小，插入点为0，则返回－1。如果比所有数都大，则插入点为len，则返回-(len + 1)。所以我们如果要通过这个返回值来算插入点的话，可以用-(ret + 1)
<br/>

十，Arrays.asList(a, b, c)能返回一个list，不过要注意的是这个list是不能修改的，比如list.add(0, **)是会抛出异常的。
<br/>

十一，边界条件中包括链表的头节点，尾节点。数组的最后一个或者第一个。
<br/>

十二，要注意整数除法要先转化成浮点，如5/2=2，但是我们想要2.5
<br/>

十三，java中char是两个字节，byte是一个字节，int是4个字节，long是8个字节，unicode是两个字节。java中的char都是unicode。
<br/>

十四，List.toArray()如果不带参数，则返回Object[]，这样强制类型转换会抛异常。解决办法是传入一个空的数组，如list.toArray(new ListNode[])，这样结果会自动转换成ListNode[]
<br/>

十五，Comparator中如果return o1 > o2则表示升序，return o2 > o1表示降序，这里o1表示你要插入的数，o2表示数组中的数。表示如果要升序，则要判断插入的数o1是否比数组中的当前数o2大，如果要降序，则要判断插入的数o1是否比数组中的当前数o2小。
另外一定要注意不要直接return o1 - o2或者o2 - o1，会出问题，比如你要降序排列，先插入了一个INT_MIN，之后插入的任何数与INT_MIN相减都会溢出成负数，则会认为比INT_MIN小，那么INT_MIN就会被认为是最大的了。
<br/>

十六，Priority Queue，如果直接迭代，则结果不一定是我们想要的按序排列的。应该在一个循环中不断poll，因为这个queue只能保证其顶端是最大的或者最小的，当你弹出顶端后，queue会调整使得新的顶端仍然是当前最大或最小的。只能通过这种不断弹出顶端的方式来获取有序序列。
<br/>

十七，判断多个条件是否同时成立可以采用bitmap，一个整数有32个bit，每个bit分别代表某个条件是否满足，如果不满足则置为1，满足则置为0，如果这个int为0则表示所有条件都满足。
<br/>

十八，TreeSet中floor(n)返回小于等于n的最大值，ceiling(n)返回大于等于n的最小值，如果值不存在则返回null。
<br/>

十九，如果要删除ArrayList中某一段，可以采用list.sublist(1,3).clear(); 注意这个3是开区间。
<br/>

二十，如果要返回最什么的结果，比如出现次数最多，最大，最小等，要注意可能结果会有几个，也可能没有
<br/>

二十一，对于含有全局变量的解法，要注意有可能存在多线程的问题
<br/>

二十二，时刻重视可能存在整数溢出的问题
<br/>

二十三，求除或者取余时要注意除数为零的情况
<br/>

二十四，String.format效率很低，还不如直接字符串相加
<br/>

二十五，PriorityQueue的add和poll复杂度是O(lgn)，peek复杂度是O(l)，但是remove(Object)复杂度是O(n)，这个一定要注意，要避免remove(Object)。如果确实要remove，则可用TreeMap或TreeSet代替，TreeMap内部实现为红黑树，添加删除查找的复杂度都为O(lgn)，这点不要和HashMap搞混了，HashMap的添加删除查找都是O(l)。PriorityQueue如果允许元素重复，则要改成TreeMap保存元素次数
<br/>

二十六，关于for (char c : str.toCharArray()) {}，注意这里toCharArray只会调一次
<br/>

二十七，value为Integer的map.get(key)，可能返回null，如果直接转换成int会报NPR
<br/>

二十八，对整数取负时要注意可能溢出，对于-2147483648取负会溢出，见pow()
<br/>

二十九，PriorityQueue或TreeMap的comparator要注意，如果升序则o1 - o2，降序则o2 - o1，考虑
溢出的风险，升序则
```
if (o1 > o2) return 1;
if (o1 == o2) return 0;
return -1;
```
不能直接写return o1 > o2 ? 1 : -1；
因为可能存在重复的数，在TreeMap中查找key时通过comparator等于0，上述写法导致永远找不到key。

三十，StringBuilder的insert(0, c)不要频繁调用，看源码要array copy，性能很差。不如append，最后reverse。

三十一，List在allAll一个PriorityQueue时，是不会带顺序的，正确的做法是while(!queue.isEmpty()) {list.add(queue.poll());}
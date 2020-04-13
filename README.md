# 数据结构与算法分析

## 数据结构 datastructure
### Integer 与int的不同
  // 关于int与Integer的问题的处理
     https://blog.csdn.net/tongsiw/article/details/89851213?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
        

#### 线性表 linklist
* 线性表的存储有两种：顺序存储表，链式存储表。
* 顺序存储结构：要求数据存放的物理和逻辑地址连续
* 链式存储：存放地址可连续可不连续。
* 双向链式存储，指针往前往后都可以。
* 用迭代器打印线性表 很方便 参考 diedaiqi


* ArrayList 与List:  
ArrayList（顺序存储） 类提供了List ADT 的一种可增长数组的实现。
使用ArrayList的优点在于，对get和set的调用花费常数时间。其缺点是新项的插入和现有项的删除代价昂贵。
除非变动是在ArrayList末端进行。  
LinkedList（链式存储） 类则提供了List ADT 的双链表实现。
使用LinkedList的优点在于，新项的插入和现有项的删除开销很小。
由此，LinkedList提供了方法addFirst和removeFirst、addLast和removerLast、以及getFirst和getLast等以有效地添加、删除、访问表两端的项。
使用LinkedList的缺点是它不容易作索引，因此对get的调用是昂贵的，除非调用在接近表的端点。

* MyArrayList 实现内部迭代器类
* MyLinkedList  实现自定义 链表


### 堆栈 stack  
* 先进后出
* 顺序栈
* 链式堆栈

### 队列 queue
* 先进先出

### 数组
* 存储同一类型的数据结构
* 数组与线性表之间的关系？？？？  
逻辑结构：  
结构定义中是对操作对象的数学描述，描述的是 数据元素之间的 逻辑关系。 例如：线性结构、树形结构、图状结构，网状等  
物理结构：存储结构  
是数据结构在计算机中的表示（又称映像），例如 数组，指针。  
所以：  
线性表： 属于逻辑结构中的线性结构，包括顺序表和链表  
数组：一种物理结构，它的存储单元是连续的  
* 查看类型：  
 System.out.println(a.getClass().getSimpleName());


### 树 tree
* 二叉树搜索 BinNodeSearchTree
* 二叉树存储结构
![avatar](resource/二叉树存储结构.png)
* 哈夫曼树
* AvlNodeTree  平衡二叉树  左旋，右旋，双旋实现平衡。

### map  映射
* treeMap  
    CoumputeWords 用于计算 两个单词只有一个字符不同的 map
* hashMap

### 散列 hase
标准库中包括Set和Map的散列表的实现，即HashSet类 和 HashMap类  
HashSet中的项必须提供equals方法 和 hashCode方法  
HashSet 和 HashMap 通常是用分离链接散列实现的。  数组+链表 来解决这个问题
  
这篇文章不错，推荐：https://blog.csdn.net/brycegao321/article/details/52527236  
详细分析了hashMap，首先默认hashMap的长度为16，当出现hashCode碰撞的时候，利用链表来解决这个问题。当出现更多的时候，即搜索到该值为0（N）
比较糟糕的情况，通过红黑树来解决。
如果容量不足，控制在0.75，则重新分配资源。
另外注意hashTable，跟hashMap一样，但有细微差别


### 优先队列 heap 堆
标准库中有java.util.PriorityQueue 具体实现逻辑是不是也是用的二叉树转为数组存储的方式，不太清楚。




### 图 graph
* 有向图  
从一个顶点指向另一个顶点，每条边都是顶点的有序偶对。
* 无向图  
如果边没有方向性，即每条边都是顶点的无序偶对，则为无向图。


* 欧拉回路
* 深度优先与 广度优先
* NP完全性


 ### 排序
 * 排序方法性能比较表
 ![avatar](resource/排序方法性能比较表.png)
* 定理一：N个互异数的数组的平均逆序数是N(N-1)/4
* 定理二：通过交换相邻元素进行排序的任何算法平均都需要O（N^2）
* 上述两个定理就决定了 类似 插入、选择、冒泡排序，由于是直接交换两个 互异数， 其算法的时间复杂度必为 O（N^2）
* 堆排序：https://zh.wikipedia.org/wiki/%E5%A0%86%E6%8E%92%E5%BA%8F#Java
* 归并排序：https://zh.wikipedia.org/zh-hans/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F#Java
* 快速排序：https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F

### union/find

## 算法algorithm
### 贪婪算法 greedy algorithm
* prim算法
* Dijkstra 算法  贪婪算法的代表 https://zh.wikipedia.org/zh-hans/%E6%88%B4%E5%85%8B%E6%96%AF%E7%89%B9%E6%8B%89%E7%AE%97%E6%B3%95
* kruskal算法  https://zh.wikipedia.org/wiki/%E5%85%8B%E9%B2%81%E6%96%AF%E5%85%8B%E5%B0%94%E6%BC%94%E7%AE%97%E6%B3%95
* 哈夫曼算法
 这种算法，主要利用树的结构  左叶为0 右叶为1  只有页节点有数据。  将频率最低的  放在最远的地方。
 
* 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。



### 分治算法  divide  and  conquer
 ![avatar](resource/分治算法定理.png)
 ![avatar](resource/分治算法定理2.png)
* 整数相乘  可以猜想 将整数分为两部分来分别治理
* 矩阵乘法 
*


### 动态规划  dynamic programming
pack 背包问题


### 随机化算法 randomized algorithm
* 伪随机数  pseudorandom


### 回溯算法

### javaguide 
* 来源：https://snailclimb.gitee.io/javaguide-interview/#/./docs/c-3%E7%AE%97%E6%B3%95
* 一些经典算法的了解


## java基础  javademo

### basic
Hello.java：静态代码块，继承，重写 
ArraysTest  Arrays常用
#### 堆内存与栈内存的区别
* 1 栈stack：为编译器自动分配和释放，如函数参数、局部变量、临时变量等等
* 2 堆heap：为成员分配和释放，由程序员自己申请、自己释放。否则发生内存泄露。典型为使用new申请的堆内容。


### thread 线程
线程锁：DeadLockDemo
线程安全单例模式：PropertyHolderLazy


### io
io处理
*bio  阻塞同步io

待办：
QuickUnionUF.java

 QuickFindUF.java



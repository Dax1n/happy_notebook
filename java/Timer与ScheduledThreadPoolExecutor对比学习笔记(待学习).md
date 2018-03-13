### 待学习，有时间翻阅一下源码查看究竟

- 博客地址：http://blog.csdn.net/riyunzhu/article/details/8070199  



·Timer对调度的支持是基于绝对时间的，因此任务对系统时间的改变是敏感的；而ScheduledThreadPoolExecutor支持相对时间。
·Timer使用单线程方式来执行所有的TimerTask，如果某个TimerTask很耗时则会影响到其他TimerTask的执行；而ScheduledThreadPoolExecutor则可以构造一个固定大小的线程池来执行任务。
·Timer不会捕获由TimerTask抛出的未检查异常，故当有异常抛出时，Timer会终止，导致未执行完的TimerTask不再执行，新的TimerTask也不能被调度；ScheduledThreadPoolExecutor对这个问题进行了妥善的处理，不会影响其他任务的执行。




- ServiceLoader 使用


-  AbstractProcessor

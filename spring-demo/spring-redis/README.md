
## 几种常见的应用场景

统计访问次数
incr OFFICIAL_INDEX_VISIT_COUNT

添加多次
incrby OFFICIAL_INDEX_VISIT_COUNT 5

排行榜
ZADD rank:score 100 "周星驰"
ZADD rank:score 90 "周杰伦"
ZADD rank:score 80 "周润发"
ZRANGE rank:score 0 -1 WITHSCORES

位统计
setbit user:view:2024-01-17 123456 1
getbit user:view:2024-01-17 123456

全局ID
incrby userid 10000

## 使用redis和AOP切面进行限流

参考连接: https://www.cnblogs.com/blbl-blog/p/17944006
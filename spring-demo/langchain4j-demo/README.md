http://localhost:8080/chat?message=你好啊

AI志愿填报顾问: http://localhost:8080/

docker run --name redis-vector -d -p 6380:6379 redislabs/redisearch
安装redis: docker run --name redis -d -p 6379:6379 redis
停止原有的redis镜像: docker stop redis  
删除原有的redis镜像: docker rm redis
安装带有向量化功能的redis: docker run --name redis-vector -d -p 6379:6379 redislabs/redisearch
安装mysql: docker run --name mysql -d -p 3307:3306 -e MYSQL_ROOT_PASSWORD=1234 mysql

# sunfiled_demo_qu

Implement a Uses Rate Limiter for APIs

What is a Rate Limiter?
Rate limiting is used to control the amount of incoming and outgoing traffic to or from a network. For example, let's say you are using a particular service's API that is configured to allow 100 requests/minute. If the number of requests you make exceeds that limit, then an error will be triggered. The reasoning behind implementing rate limits is to allow for a better flow of data and to increase security by mitigating attacks such as DDoS. 

Features:
1.Transaction per second limits based on license (user specific).
2.Throttling capabilities.
Ex: Let’s say TPS agreement is 100, and in first 10 milliseconds 90 requests came then rate limiter will make sure that only 10 request passes through in 1 sec boundary.





运行说明：

1.创建本地 mysql 数据库 db_demo 

2.修改配置文件 application.properties 本地数据库账号密码  

3.运行 DemoAppplication

4.运行 sql 语句 
INSERT INTO `db_demo`.`api_config` (`id`, `name`, `num`) VALUES ('1', 'api 测试每秒钟限制访问数量', '10');

5.访问 API 路径 http://localhost:8080/demo/api
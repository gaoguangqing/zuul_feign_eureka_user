# zuul_feign_eureka_user
SpringCloud整合zuul,feign,erueka实现消费者负载均衡

#配置两个消费者的时候name要保持一致，但是注意服务器端口号的不同
消费者1application.yml
```
server:
  port: 9001
spring:
  application:
    name: user-consumer
eureka:
  client:
    serviceUrl:
      defaultZone: http://user:password@localhost:8761/eureka
logging:
  level:
    root: INFO
```
消费者2application.yml
```
server:
  port: 9002
spring:
  application:
    name: user-consumer
eureka:
  client:
    serviceUrl:
      defaultZone: http://user:password@localhost:8761/eureka
logging:
  level:
    root: INFO

```
配置zuul时要注意更改下面两处

#### 第一处:application.yml serviceId: user-consumer
```
server:
  port: 8050
spring:
  application:
    name: gateway-zuul
  resources:
    static-locations: classpath:/statis/
eureka:
  client:
    serviceUrl:
      defaultZone: http://user:password@localhost:8761/eureka
zuul:
  routes:
    app-zuul:
      path: /school/**
      serviceId: user-consumer
```
#### 第二处:ZuulFallback return "user-consumer";
```
@Override	//获取路由，application.name
	public String getRoute() {
		return "user-consumer";
	}
```
注意访问路径是 http://localhost:8050/school/user/findAll

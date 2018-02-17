# How To Start

## ENV Prepare：

| Tool  | Version              |
| ----- | -------------------- |
| JDK   | 1.8                  |
| IDE   | STS or IntelliJ IDEA |
| Maven | 3.x                  |

## host-config：

| host-config（C:\Windows\System32\drivers\etc\hosts） |
| ---------------------------------------- |
| 127.0.0.1 discovery config-server gateway movie user feign ribbon |

## List：

| ProjectName                              | Port | Description                         | URL             |
| ---------------------------------------- | ---- | ----------------------              | --------------- |
| microservice-api-gateway                 | 8050 | API Gateway                         |                 |
| microservice-config-client               | 8041 | config                              |                 |
| microservice-config-server               | 8040 | config                              |                 |
| microservice-consumer-movie-feign        | 8020 | Feign Demo                          | /feign/1        |
| microservice-consumer-movie-feign-with-hystrix | 8021 | Feign Hystrix Demo            | /feign/1        |
| microservice-consumer-movie-feign-with-hystrix-stream | 8022 | Hystrix Dashboard Demo | /feign/1        |
| microservice-consumer-movie-ribbon       | 8010 | Ribbon Demo                         | /ribbon/1       |
| microservice-consumer-movie-ribbon-with-hystrix | 8011 | Ribbon Hystrix Demo          | /ribbon/1       |
| microservice-discovery-eureka            | 8761 | Register Center                     | /               |
| microservice-hystrix-dashboard           | 8030 | hystrix                             | /hystrix.stream |
| microservice-hystrix-turbine             | 8031 | turbine                             | /turbine.stream |
| microservice-provider-user               | 8000 |                                     | /1              |
|                                          |      |                                     |                 |






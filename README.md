# Spring-Templates

config-server-template: barebones config server
eureka-client-jdbc-jpa-feign-queue-template: microservice-ready template, with all the dependencies for an edge service (minus security/oauth) but can be configured for any service
eureka-feign-queue-template: a queueing microservice with the ability to use feign clients to manipulate data
eureka-server-template: barebones eureka server
jpa-ready-template: just a spring web application using JPA, much less dependencies than eureka-client-jdbc-jpa-feign-queue-template
oath2-jdbc-server-template: oath2 server using jdbc to communicate with database
security-jdbc-jpa-template: security config service using jdbc prepared statements

# Distributed Tracing Using Spring-Cloud-Sleuth

[Spring Cloud Sleuth](https://github.com/spring-cloud/spring-cloud-sleuth) is a distributed tracing tool for Spring Cloud. It borrow from Dapper, Zipkin and HTrace. 

This Demo application shows Sleuth's distributed tracing capability. 

## How to use the demo application

1. Clone the respository using the command `git clone https://github.com/dhaval24/Sleuth-Demo.git`
2. Set up Zipkins by following [this](https://opencensus.io/codelabs/zipkin) guided lab.
3. Start the Greeting-Rest-Service by `cd Greeting-Rest-Service` and run `mvnw spring-boot:run`
4. Start the Greeting-Rest-Conspumption-Service by `cd Greeting-Rest-Conspumption-Service` and run `mvnw spring-boot:run`
5. Hit some url's by using the following command `curl http://localhost:8082/greetingscaller`
6. View the traces on [Local Zipkins](http://localhost:9411)
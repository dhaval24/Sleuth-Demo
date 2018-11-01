package hello;

import brave.http.HttpTracing;
import brave.httpclient.TracingHttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class GreetingConsumerController {

    private static final Logger log = LoggerFactory.getLogger(GreetingConsumerController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpClient httpClient;

    @Bean
    HttpClient httpClient(HttpTracing httpTracing) {
       return TracingHttpClientBuilder.create(httpTracing).build();
    }

    @RequestMapping("/greetingscaller")
    public String greetingsCaller() {
        Greeting greeting = restTemplate.getForObject("http://localhost:8081/greeting", Greeting.class);
        log.info(greeting.toString());

        return "/greeting called";
    }

    @RequestMapping("/greetingscallerUsingApacheHttp")
    public String greetingsCallerUsingApacheHttpClient() throws IOException {
        HttpResponse response = httpClient.execute(new HttpGet("http://localhost:8081/greeting"));
        log.info(response.toString());

        return "/greetingscallerUsingApacheHttp called";
    }
}

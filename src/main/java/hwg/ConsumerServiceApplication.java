package hwg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients     //激活Feign组件
@EnableDiscoveryClient  //开启微服务发现（非Eureka作为注册中心时使用）
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    /**
     * Spring Cloud对Consul做了进一步的处理，想其中集成了ribbon的支持
     * ribbon ：springCloud提供的负载均衡器
     * @return
     */
    @LoadBalanced
    @Bean
    RestTemplate getRestTemlaate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}

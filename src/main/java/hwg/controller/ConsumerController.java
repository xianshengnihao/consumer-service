package hwg.controller;

import hwg.feign.ProductFeignClient;
import hwg.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author: hwg
 * @Date: Create in 2020/1/13
 */
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate rest;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    /**
     * 使用RestTemplate远程调用
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Country HelloConsul(){
        String url="http://product-service/consul";
        Country country =  rest.getForObject(url,Country.class);
        return country;
    }

    /**
     * 使用Feign组件实现远程调用
     * @return
     */
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public Object HelloFeign(){
        Object country =  productFeignClient.HelloFeign();
        System.out.println(redisTemplate.opsForValue().get("key"));
        return country;
    }


}

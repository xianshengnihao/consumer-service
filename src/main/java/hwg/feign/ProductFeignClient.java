package hwg.feign;

import hwg.model.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @Author: hwg
 * @Date: Create in 2020/2/5
 * 声明需要调用的微服务名称
 */
@FeignClient(name = "product-service")
public interface ProductFeignClient {

    /**
     * 只需要调用的微服务接口
     */
    @RequestMapping(value = "/consul",method = RequestMethod.GET)
    public Map<?,?> HelloFeign();
}

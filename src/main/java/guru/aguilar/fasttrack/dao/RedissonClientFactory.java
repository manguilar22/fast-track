package guru.aguilar.fasttrack.dao;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@PropertySource("classpath:application.properties")
public class RedissonClientFactory implements Supplier<RedissonClient> {


    @Value("${spring.redis.host}")
    private String REDIS_HOST;

    @Value("${spring.redis.port}")
    private Integer REDIS_PORT;


    @Override
    public RedissonClient get() {
        String url = String.format("redis://%s:%d",REDIS_HOST,REDIS_PORT);
        Config config = new Config();
        config.useSingleServer()
                .setAddress(url);
        return Redisson.create(config);
    }
    
}

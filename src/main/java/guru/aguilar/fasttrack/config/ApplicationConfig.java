package guru.aguilar.fasttrack.config;

import guru.aguilar.fasttrack.dao.Student;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan("guru.aguilar.fasttrack.*")
public class ApplicationConfig {

    @Bean
    public JedisConnectionFactory redisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Student> redisTemplate(){
        RedisTemplate<String,Student> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

}



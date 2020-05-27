package guru.aguilar.fasttrack.config;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.wavefront.WavefrontConfig;
import io.micrometer.wavefront.WavefrontMeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableAutoConfiguration
@EnableCaching
@ComponentScan("guru.aguilar.fasttrack.*")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${spring.redis.host}")
    private String REDIS_HOST;

    @Value("${spring.redis.port}")
    private Integer REDIS_PORT;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();

        configuration.setHostName(REDIS_HOST);
        configuration.setPort(REDIS_PORT);

        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<?,?> redisTemplate(){
        RedisTemplate<byte[],byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

    @Bean
    public MeterRegistry meterRegistry(){
        WavefrontConfig config = new WavefrontConfig() {
            @Override
            public String uri() {
                return "proxy://127.0.0.1:2878";
            }

            @Override
            public String get(String key) {
                return null;
            }

            @Override
            public String prefix() {
                return "wavefront";
            }
        };
        MeterRegistry registry = new WavefrontMeterRegistry(config, Clock.SYSTEM);

        return registry;

    }


}



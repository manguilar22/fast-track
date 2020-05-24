package guru.aguilar.fasttrack.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("guru.aguilar.fasttrack.*")
public class ApplicationConfig {

}
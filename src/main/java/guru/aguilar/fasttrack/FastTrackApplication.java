package guru.aguilar.fasttrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class FastTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastTrackApplication.class, args);
	}

}

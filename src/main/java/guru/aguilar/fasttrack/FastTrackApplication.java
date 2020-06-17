package guru.aguilar.fasttrack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class FastTrackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FastTrackApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}

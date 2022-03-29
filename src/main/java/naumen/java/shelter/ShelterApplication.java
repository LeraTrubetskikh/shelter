package naumen.java.shelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("naumen/java/shelter/repository")
@EntityScan("naumen/java/shelter/model")
public class ShelterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelterApplication.class, args);
	}
}

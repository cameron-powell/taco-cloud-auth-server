package tacos.authserver;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TacoCloudAuthServerApplication {

	@Bean
	public ApplicationRunner dataLoader(
		UserRepository userRepo,
		PasswordEncoder encoder
	) {
		return args -> {
			userRepo.save(new User(
				"buzz",
				encoder.encode("password"),
				"Buzz Lightyear",
				"123 Toy Street",
				"San Francisco",
				"CA",
				"12345",
				"555-5555"
			));
			userRepo.save(new User(
				"woody",
				encoder.encode("password"),
				"Woody Pride",
				"1000 Toy Box Lane",
				"San Francisco",
				"CA",
				"12345",
				"555-5555"
			));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudAuthServerApplication.class, args);
	}

}

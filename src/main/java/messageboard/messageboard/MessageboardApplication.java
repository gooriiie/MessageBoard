package messageboard.messageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MessageboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageboardApplication.class, args);
	}

}

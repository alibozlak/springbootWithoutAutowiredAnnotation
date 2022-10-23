package bozlak.autowiredless;

// import static java.lang.System.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutowiredlessApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		// System.getProperties().entrySet().forEach(out::println);
		SpringApplication.run(AutowiredlessApplication.class, args);
	}

}

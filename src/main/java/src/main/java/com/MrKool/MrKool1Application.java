package src.main.java.com.MrKool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class MrKool1Application {

	public static void main(String[] args) {

		SpringApplication.run(MrKool1Application.class, args);
	}

}

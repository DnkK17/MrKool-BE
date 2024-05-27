package src.main.java.com.MrKool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@springfox.documentation.swagger2.annotations.EnableSwagger2
@org.springframework.scheduling.annotation.EnableScheduling
@org.springframework.web.servlet.config.annotation.EnableWebMvc
public class MrKool1Application {

	public static void main(String[] args) {
		SpringApplication.run(MrKool1Application.class, args);
	}

}

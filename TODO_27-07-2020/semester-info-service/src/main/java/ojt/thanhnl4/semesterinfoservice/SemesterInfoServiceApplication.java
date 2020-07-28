package ojt.thanhnl4.semesterinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SemesterInfoServiceApplication {
	@Bean
	public WebClient.Builder webBuilder() {
		return WebClient.builder();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SemesterInfoServiceApplication.class, args);
	}

}

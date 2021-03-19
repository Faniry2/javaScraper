package fa.whois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"fa.whois.controller","fa.whois.service","fa.whois.exceptionController"})
public class WhoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhoisApplication.class, args);
	}

}

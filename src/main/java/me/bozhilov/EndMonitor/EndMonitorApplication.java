package me.bozhilov.EndMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "me.bozhilov.EndMonitor.repository")
public class EndMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndMonitorApplication.class, args);
	}

}

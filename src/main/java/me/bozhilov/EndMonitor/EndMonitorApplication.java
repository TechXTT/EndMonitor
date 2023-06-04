package me.bozhilov.EndMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import me.bozhilov.EndMonitor.config.OpenAPIConfiguration;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "me.bozhilov.EndMonitor.repository")
@Import(OpenAPIConfiguration.class)
public class EndMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndMonitorApplication.class, args);
	}

}

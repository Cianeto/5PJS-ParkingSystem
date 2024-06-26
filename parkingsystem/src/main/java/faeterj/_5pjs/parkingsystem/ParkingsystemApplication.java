package faeterj._5pjs.parkingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParkingsystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParkingsystemApplication.class, args);
	}
}

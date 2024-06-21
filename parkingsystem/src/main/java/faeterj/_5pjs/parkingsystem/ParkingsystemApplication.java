package faeterj._5pjs.parkingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import faeterj._5pjs.parkingsystem.dto.ClienteDTO;
import faeterj._5pjs.parkingsystem.service.ClienteService;

@SpringBootApplication
public class ParkingsystemApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ParkingsystemApplication.class, args); // Fiz isso pra conseguir fazer o teste na main
		ApplicationContext context = SpringApplication.run(ParkingsystemApplication.class, args);
		ClienteService teste = context.getBean(ClienteService.class);

		ClienteDTO cliente = new ClienteDTO("Zé Maluco", "123.123.123-01", "(21) 98361-4941");

		teste.insertNewCliente(cliente);
	}

}

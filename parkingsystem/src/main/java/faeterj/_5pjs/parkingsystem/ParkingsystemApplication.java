package faeterj._5pjs.parkingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import faeterj._5pjs.parkingsystem.dto.ClienteDTO;
import faeterj._5pjs.parkingsystem.service.ClienteService;

@SpringBootApplication
public class ParkingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingsystemApplication.class, args);

		ClienteService teste = new ClienteService();
		ClienteDTO cliente = new ClienteDTO("Zé Maluco", "123.123.123-01", "(21) 98361-4941");

		teste.insertNewCliente(cliente);
	}

}

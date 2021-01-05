package hr.fer.rassus.lti;

import hr.fer.rassus.lti.entitiy.Temperature;
import hr.fer.rassus.lti.repository.TemperatureRepository;
import hr.fer.rassus.lti.util.TemperatureLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class TemperatureMicroserviceApplication {

	public TemperatureMicroserviceApplication(TemperatureRepository repository) {
		TemperatureLoader loader = new TemperatureLoader();
		List<Temperature> temperatures = loader.getTemperatures().stream()
				.map(Temperature::new)
				.collect(Collectors.toList());
		temperatures.forEach(repository::save);
	}

	public static void main(String[] args) {
		SpringApplication.run(TemperatureMicroserviceApplication.class, args);
	}
}

package hr.fer.rassus.lti.repository;

import hr.fer.rassus.lti.entitiy.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
    Temperature getById(Integer id);
}

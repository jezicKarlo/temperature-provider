package hr.fer.rassus.lti.repository;

import hr.fer.rassus.lti.entitiy.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Integer> {
    Temperature getById(Integer id);
}

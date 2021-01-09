package hr.fer.rassus.lti.service;

import hr.fer.rassus.lti.repository.TemperatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class TemperatureService {
    private final TemperatureRepository temperatureRepository;

    public Integer fetchTemperature() {
        return temperatureRepository.getById(generateId()).getTemperature();
    }

    private int generateId() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        return 4 * hour + minute / 15;
    }
}

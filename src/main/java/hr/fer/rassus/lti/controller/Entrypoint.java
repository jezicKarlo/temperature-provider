package hr.fer.rassus.lti.controller;

import hr.fer.rassus.lti.response.Response;
import hr.fer.rassus.lti.service.TemperatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temperatures")
public class Entrypoint {

    private final TemperatureService temperatureService;

    public Entrypoint(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping
    public ResponseEntity<Response> getTemperature() {
        return ResponseEntity.ok(new Response(temperatureService.fetchTemperature()));
    }
}

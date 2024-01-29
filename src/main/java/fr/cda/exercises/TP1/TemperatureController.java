package fr.cda.exercises.TP1;

import org.springframework.web.bind.annotation.*;

@RestController
public class TemperatureController {

    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/temperature")
    public Temperature getTemperature(@RequestParam(required = false) Double celsius) {

        if (celsius == null) {
            return temperatureService.convertTemperature(0, "celsius");
        } else {
            return temperatureService.convertTemperature(celsius, "celsius");
        }
    }

    @PostMapping("/temperature/convert")
    public Temperature convertTemperature(@RequestBody TemperatureDTO temperatureDTO) {
        return temperatureService.convertTemperature(temperatureDTO.getValue(), temperatureDTO.getUnit());
    }
}
package fr.cda.exercises.TP1;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    public Temperature convertTemperature(double value, String unit) {

        double celsius = convertToCelsius(value, unit);
        double fahrenheit = celsius * 1.8 + 32;
        double kelvin = celsius + 273.15;

        return new Temperature(celsius, fahrenheit, kelvin);
    }

    private double convertToCelsius(double value, String unit) {

        return switch (unit) {
            case "fahrenheit" -> (value - 32) / 1.8;
            case "kelvin" -> value - 273.15;
            default -> value;
        };
    }
}
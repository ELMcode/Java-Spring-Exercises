package fr.cda.exercises.TP1;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureDTO {

    private double value;
    private String unit;
}
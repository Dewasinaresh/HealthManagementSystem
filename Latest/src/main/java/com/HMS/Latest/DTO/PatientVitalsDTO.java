package com.HMS.Latest.DTO;

import com.HMS.Latest.Entity.PatientEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientVitalsDTO {

    private String boolPressure;
    private int bloodPressure;
    private int sugarLevel;
    private int heartRate;
    private int height;
    private   int weight;
    @JsonIgnore
    private PatientEntity patientEntity;
}

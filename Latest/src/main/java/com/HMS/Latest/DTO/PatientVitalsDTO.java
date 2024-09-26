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

    public String boolPressure;
    public int bloodPressure;
    public int sugarLevel;
    public int heartRate;
    public int height;
    public   int weight;
    @JsonIgnore
    public PatientEntity patientEntity;
}

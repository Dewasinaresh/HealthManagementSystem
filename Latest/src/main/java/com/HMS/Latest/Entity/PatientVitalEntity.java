package com.HMS.Latest.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PATIENT_VITAL")
public class PatientVitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String pntVitalId;

    private int bloodPressure;
    private int sugarLevel;
    private int heartRate;
    private int height;
    private  int weight;

    @OneToOne
    @JoinColumn(name = "patient_Id")
    private   PatientEntity patientId;





}


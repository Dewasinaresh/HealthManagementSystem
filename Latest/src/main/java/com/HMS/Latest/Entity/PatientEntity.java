package com.HMS.Latest.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PATIENT")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private String patientName;

    private int age;

    private String gender;

    //Other Mapping
    // doctor and patient
    @ManyToOne
    DoctorEntity doctorEntity;


    @OneToMany(mappedBy = "patientId")
    List<AppointmentEntity> ListOfAppointment;


    @OneToMany(mappedBy = "patientOne")
    List<PatientMedicalEntity> patientMedicalList;


    @OneToOne(mappedBy = "patientId", cascade = CascadeType.ALL)
    private PatientVitalEntity patientVitalEntity;

}

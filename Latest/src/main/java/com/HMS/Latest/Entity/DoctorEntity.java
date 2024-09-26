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
@Table(name = "DOCTOR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Of_Doctor",discriminatorType = DiscriminatorType.STRING)
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    @Column(name = "Doctor_Name")
    private String doctorName;
    @Column(name = "Doctor_Specifiction")
    private String doctorSpecification;


    // Patient & Doctor
    @OneToMany(mappedBy = "doctorEntity")
    List<PatientEntity> listOfPatient;

    @OneToMany(mappedBy = "doctorId")
    List<AppointmentEntity> appointmentList ;


}

package com.HMS.Latest.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PATIENT_MEDICAL_DETAILS")
public class PatientMedicalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String patientMdclId;

    private LocalDate createdDate;

    private String diseaseName;

    private boolean isRecover;

    //Other Mapping

    //Association

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient_id" )
    private  PatientEntity patientOne;


}

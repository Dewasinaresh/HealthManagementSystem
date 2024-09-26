package com.HMS.Latest.DTO;


import com.HMS.Latest.Entity.AppointmentEntity;
import com.HMS.Latest.Entity.PatientEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDTO {


    private String doctorName;
    private String typeOfDoctor;
    private String doctorSpecification;

/*
    // Patient & Doctor
    @OneToMany(mappedBy = "doctorEntity")
    List<PatientEntity> listOfPatient;

    @OneToMany(mappedBy = "doctor")
    List<AppointmentEntity> appointmentList ;
  */

}

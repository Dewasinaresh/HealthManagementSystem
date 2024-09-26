package com.HMS.Latest.DTO;

import com.HMS.Latest.OwnLiteral.AppointmentStatus;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {


    public LocalDate appointmentDate;

    public AppointmentStatus status;

    public PatientDTO patientDTO;


}

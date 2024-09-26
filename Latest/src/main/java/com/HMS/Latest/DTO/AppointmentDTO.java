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


    private LocalDate appointmentDate;

    private AppointmentStatus status;

    private PatientDTO patientDTO;


}

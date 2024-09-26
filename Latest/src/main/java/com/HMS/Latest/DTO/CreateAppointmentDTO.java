package com.HMS.Latest.DTO;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAppointmentDTO {

    private int patientId;

    private  String doctorSpecification;

    private String doctorName;

    private LocalDate appointmentDate;








}

package com.HMS.Latest.DTO;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAppointmentDTO {

    public int patientId;

    public  String doctorSpecification;

    public String doctorName;

    public LocalDate appointmentDate;








}

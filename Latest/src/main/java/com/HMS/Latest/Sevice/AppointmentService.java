package com.HMS.Latest.Sevice;

import com.HMS.Latest.DTO.AppointmentDTO;
import com.HMS.Latest.DTO.CreateAppointmentDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService{

    public String bookAppointment(CreateAppointmentDTO createAppointmentDTO);
    public List<AppointmentDTO> searchAppointments(Long doctorId, LocalDate fromDate, LocalDate toDate);

}

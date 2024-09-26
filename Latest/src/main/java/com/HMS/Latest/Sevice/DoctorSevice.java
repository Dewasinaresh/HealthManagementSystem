package com.HMS.Latest.Sevice;

import com.HMS.Latest.DTO.CreateAppointmentDTO;
import com.HMS.Latest.DTO.DoctorDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface DoctorSevice {

    public String createDoctor(DoctorDTO doctorDTO);

}

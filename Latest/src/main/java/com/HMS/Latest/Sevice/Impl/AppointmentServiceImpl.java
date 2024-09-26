package com.HMS.Latest.Sevice.Impl;

import com.HMS.Latest.DTO.AppointmentDTO;
import com.HMS.Latest.DTO.CreateAppointmentDTO;
import com.HMS.Latest.Entity.AppointmentEntity;
import com.HMS.Latest.OwnLiteral.AppointmentStatus;
import com.HMS.Latest.Repository.AppointmentRepo;
import com.HMS.Latest.Sevice.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public AppointmentRepo appointmentRepo;


    @Override
    public String bookAppointment(CreateAppointmentDTO createAppointmentDTO) {

        //CheckAppointAppointment(LocalDate bookingDate);
        //getPatient(int patientId);

        AppointmentEntity appointmentEntity = AppointmentEntity.builder()
                .appointmentDate(createAppointmentDTO.getAppointmentDate())
                .status(AppointmentStatus.BOOKED)
                .build();

        appointmentRepo.save(appointmentEntity);



        return "Appointment has been booked";
    }

    @Override
    public List<AppointmentDTO> searchAppointments(Long doctorId, LocalDate fromDate, LocalDate toDate) {

        List<AppointmentEntity> appointmentList = appointmentRepo.findAppointmentsByDoctorAndDate(doctorId, fromDate, toDate);
        List<AppointmentDTO> listOfAppointments = appointmentList.stream().map(appointmentEntity -> modelMapper.map(appointmentEntity, AppointmentDTO.class)).collect(Collectors.toList());
        return listOfAppointments;

    }
}

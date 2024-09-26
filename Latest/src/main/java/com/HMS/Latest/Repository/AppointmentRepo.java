package com.HMS.Latest.Repository;

import com.HMS.Latest.Entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Integer> {

    @Query("SELECT a FROM AppointmentEntity a WHERE a.doctorId = :doctorId AND a.appointmentDate BETWEEN :fromDate AND :toDate")
    List<AppointmentEntity> findAppointmentsByDoctorAndDate(Long doctorId, LocalDate fromDate, LocalDate toDate);


}

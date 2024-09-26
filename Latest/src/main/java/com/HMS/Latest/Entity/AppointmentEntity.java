package com.HMS.Latest.Entity;


import com.HMS.Latest.OwnLiteral.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "APPOINTMENTS")
public class AppointmentEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int appmtId;

        private LocalDate appointmentDate;

        private AppointmentStatus status;

        //Other Mapping
        @ManyToOne
        @JoinColumn(name = "patient_id")
        private  PatientEntity patientId;

        @ManyToOne
        @JoinColumn(name = "doctor_id")
        private  DoctorEntity doctorId;


}

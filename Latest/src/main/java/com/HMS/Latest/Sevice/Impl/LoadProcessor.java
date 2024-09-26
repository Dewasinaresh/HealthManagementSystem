package com.HMS.Latest.Sevice.Impl;

import com.HMS.Latest.Entity.AppointmentEntity;
import com.HMS.Latest.Entity.DoctorEntity;
import com.HMS.Latest.Entity.PatientEntity;
import com.HMS.Latest.OwnLiteral.AppointmentStatus;
import com.HMS.Latest.Repository.AppointmentRepo;
import com.HMS.Latest.Repository.DoctorRepo;
import com.HMS.Latest.Repository.PatientRepo;
import com.HMS.Latest.Sevice.DoctorSevice;
import com.HMS.Latest.Sevice.LoadProcess;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

@Service
public class LoadProcessor implements LoadProcess {


    String doctorCSVfilePath="csv/doctorCSV.csv";
    String patientCSVfilePath="csv/patientCSV.csv";
    String appointmentCSVfilePath="csv/appointmentCSV.csv";

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    AppointmentRepo appointmentRepo;


    @Override
    public String loadDoctorCSV() {


        try (BufferedReader reader = new BufferedReader(new FileReader(doctorCSVfilePath))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            for (CSVRecord record : records) {
                DoctorEntity doctorEntity = DoctorEntity.builder()
                        .doctorName(record.get("doctorName"))
                        .doctorSpecification(record.get("doctorSpecification"))
                        .build();


                    doctorRepo.save(doctorEntity);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Doctor is loaded";

    }

    @Override
    public String loadPatientCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(doctorCSVfilePath))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            for (CSVRecord record : records) {
                PatientEntity patientEntity = PatientEntity.builder()
                        .patientName(record.get("patientName"))
                        .gender(record.get("patientGender"))
                        .age(Integer.valueOf(record.get("patientAge")))
                        .build();


               patientRepo.save(patientEntity);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Patient data has been loaded";
    }

    @Override
    public String loadAppointmentCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(doctorCSVfilePath))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

            for (CSVRecord record : records) {
                AppointmentEntity appointmentEntity =AppointmentEntity.builder()
                        .appointmentDate(LocalDate.parse(record.get("appointmentDate")))
                        .status(AppointmentStatus.BOOKED)
                        .build();
                appointmentRepo.save(appointmentEntity);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Patient data has been loaded";
    }
}

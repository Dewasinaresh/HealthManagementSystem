package com.HMS.Latest.Sevice.Impl;

import com.HMS.Latest.DTO.PatientDTO;
import com.HMS.Latest.DTO.PatientVitalsDTO;
import com.HMS.Latest.Entity.PatientEntity;
import com.HMS.Latest.Entity.PatientVitalEntity;
import com.HMS.Latest.Repository.DoctorRepo;
import com.HMS.Latest.Repository.PatientRepo;
import com.HMS.Latest.Repository.PatientVitalRepo;
import com.HMS.Latest.Sevice.PatientSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientSevice {

    @Autowired
    public ModelMapper modelMapper;
    @Autowired
    public PatientRepo patientRepo;

    public String massage;

    @Autowired
    public PatientVitalRepo patientVitalRepo;


    @Override
    public String createPatient(PatientDTO patientDTO) {
        PatientEntity patientEntity = modelMapper.map(patientDTO, PatientEntity.class);
        patientRepo.save(patientEntity);
        return "Patient information has been saved";
    }

    @Override
    public PatientVitalsDTO ViewPatientVital(int patientId) {


        PatientEntity patientEntity = patientRepo.findBypatientId(patientId);
        if (patientEntity!=null) {
            PatientVitalEntity patientVitalEntity = patientVitalRepo.findByPatientId(patientEntity);
            return modelMapper.map(patientVitalEntity, PatientVitalsDTO.class);
        }
        else
        {
            return null;
        }


    }

    @Override
    public String UpdatePatientVital(int patientId, PatientVitalsDTO patientVitalsDTO) {

        PatientEntity patientEntity = patientRepo.findBypatientId(patientId);
        if (patientEntity!=null) {
            PatientVitalEntity patientVitalEntity = patientVitalRepo.findByPatientId(patientEntity);
            patientVitalEntity.setBloodPressure(patientVitalsDTO.getBloodPressure());
            patientVitalEntity.setHeight(patientVitalsDTO.getHeight());
            patientVitalEntity.setWeight(patientVitalsDTO.getWeight());
            patientVitalEntity.setHeartRate(patientVitalsDTO.getHeartRate());
            patientVitalEntity.setSugarLevel(patientVitalsDTO.getSugarLevel());
            patientVitalRepo.save(patientVitalEntity);
            massage= "Patient Vitals information has been updated";
        }
        else
            massage="Patient is not found";
        return massage;


    }
}

package com.HMS.Latest.Sevice;

import com.HMS.Latest.DTO.PatientDTO;
import com.HMS.Latest.DTO.PatientVitalsDTO;

public interface PatientSevice {

    public String createPatient(PatientDTO patientDTO);
    public PatientVitalsDTO ViewPatientVital(int patientId);
    public String UpdatePatientVital(int patientId, PatientVitalsDTO patientVitalsDTO);

}

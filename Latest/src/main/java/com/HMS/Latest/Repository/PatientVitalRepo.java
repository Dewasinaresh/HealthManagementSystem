package com.HMS.Latest.Repository;

import com.HMS.Latest.Entity.PatientEntity;
import com.HMS.Latest.Entity.PatientVitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PatientVitalRepo extends JpaRepository<PatientVitalEntity,String> {

    public PatientVitalEntity findByPatientId(PatientEntity patientId);

}

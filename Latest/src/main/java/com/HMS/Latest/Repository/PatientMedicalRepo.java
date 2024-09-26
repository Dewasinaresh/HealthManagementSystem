package com.HMS.Latest.Repository;

import com.HMS.Latest.Entity.PatientMedicalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMedicalRepo extends JpaRepository<PatientMedicalEntity,String> {
}

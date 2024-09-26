package com.HMS.Latest.Repository;

import com.HMS.Latest.Entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<PatientEntity,Integer> {

        PatientEntity findBypatientId(int patientId );
}

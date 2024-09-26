package com.HMS.Latest.Repository;

import com.HMS.Latest.Entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<DoctorEntity,Integer> {

    List<DoctorEntity> findBydoctorSpecification(String doctorName);
}

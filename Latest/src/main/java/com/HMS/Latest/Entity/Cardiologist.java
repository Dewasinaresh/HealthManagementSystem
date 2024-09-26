package com.HMS.Latest.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Cardiologist")
public class Cardiologist extends DoctorEntity{

    private String speciality;
    private int experiance;
}

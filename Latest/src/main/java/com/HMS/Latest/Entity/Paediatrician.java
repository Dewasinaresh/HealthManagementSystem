package com.HMS.Latest.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Paediatrician ")
public class Paediatrician extends DoctorEntity{

    private String specialCareFor;
}

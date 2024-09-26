package com.HMS.Latest.DTO;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientMedicalDetails {


    public LocalDate createdDate;

    public String diseaseName;

    public boolean isRecover;
}

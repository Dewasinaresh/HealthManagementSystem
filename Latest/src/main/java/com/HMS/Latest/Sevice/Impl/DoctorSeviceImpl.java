package com.HMS.Latest.Sevice.Impl;

import com.HMS.Latest.DTO.DoctorComboDTO;
import com.HMS.Latest.DTO.DoctorDTO;
import com.HMS.Latest.Entity.DoctorEntity;
import com.HMS.Latest.Repository.DoctorRepo;
import com.HMS.Latest.Sevice.DoctorSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorSeviceImpl implements DoctorSevice {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public DoctorRepo doctorRepo;

    @Override
    public String createDoctor(DoctorDTO doctorDTO) {

        DoctorEntity doctorEntity = modelMapper.map(doctorDTO, DoctorEntity.class);
        doctorRepo.save(doctorEntity);
        return "Doctor information has been saved";

    }

    @Override
    public List<DoctorComboDTO> loadDoctorCombo(String specification) {
        List<DoctorEntity> doctorList = doctorRepo.findBydoctorSpecification(specification);
        List<DoctorComboDTO> listCombo = doctorList.stream().map(doctorEntity ->
                {
                    DoctorComboDTO buildCombo = DoctorComboDTO.builder()
                            .doctorName(doctorEntity.getDoctorName())
                            .doctorId(doctorEntity.getDoctorId())
                            .build();
                    return buildCombo;
                }


        ).collect(Collectors.toList());

        return listCombo;
    }
}

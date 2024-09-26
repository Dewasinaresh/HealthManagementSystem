package com.HMS.Latest.Controller;


import com.HMS.Latest.DTO.AppointmentDTO;
import com.HMS.Latest.DTO.DoctorComboDTO;
import com.HMS.Latest.DTO.DoctorDTO;
import com.HMS.Latest.DTO.PatientVitalsDTO;
import com.HMS.Latest.Sevice.AppointmentService;
import com.HMS.Latest.Sevice.DoctorSevice;
import com.HMS.Latest.Sevice.PatientSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorSevice doctorSevice;
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientSevice patientSevice;

    @GetMapping("/DashBoard")
    public ModelAndView getmodel(){
        ModelAndView model = new ModelAndView("DoctorModule");
        return model;
    }

    @GetMapping("/Register")

    public ModelAndView getRegistration(){
        ModelAndView model = new ModelAndView("DoctorRegistration");
        return model;
    }

    @PostMapping("/saveDoctor")
    public ModelAndView saveDoctor(
            @ModelAttribute DoctorDTO doctorDTO
            ){

        ModelAndView model = new ModelAndView("Massage");
        String massager = doctorSevice.createDoctor(doctorDTO);
        model.addObject("massage",massager);
        return model;
    }

    @GetMapping("/ManageViewAppointment")
    public ModelAndView ManageAndViewAppointment(){
        ModelAndView model = new ModelAndView("ViewAppointment");
        return model;
    }

    @PostMapping("/appointmentsSearch")
    public ModelAndView viewAppointments(
            @RequestParam(name = "doctorId") Long doctorId,
            @RequestParam(name = "fromDate") LocalDate fromDate,
            @RequestParam(name = "toDate")  LocalDate toDate) {

        ModelAndView model = new ModelAndView("ViewAppointment");

        // Validate date range
        if (fromDate.isAfter(toDate)) {
            model.addObject("error", "From date must be before or equal to To date.");
            return model;
        }

        // Fetch appointments
        List<AppointmentDTO> appointments = appointmentService.searchAppointments(doctorId, fromDate, toDate);
        model.addObject("appointments", appointments);
        return model;
    }

        @GetMapping("/GetPatientDetails")
        public ModelAndView PatientDetailsBoard(){
            ModelAndView model = new ModelAndView("PatientDetailsBoard");
            return model;
        }

    @GetMapping("/PatientVitals")
    public ModelAndView PatientVitalsBoard(){
        ModelAndView model = new ModelAndView("PatientVitalsDetails");
        return model;
    }

    @GetMapping("/searchPatientVital")
    public ModelAndView patientVital(
            @RequestParam(name = "patientId") int patientId
    ){
        PatientVitalsDTO patientVitalsDTO = patientSevice.ViewPatientVital(patientId);

        ModelAndView model;
        if (patientVitalsDTO!=null) {

            model = new ModelAndView("PatientVitalsDetails");
            model.addObject("patientId", patientVitalsDTO.getPatientEntity().getPatientId());
            model.addObject("bloodPressure", patientVitalsDTO.getBloodPressure());
            model.addObject("sugarLevel", patientVitalsDTO.getSugarLevel());
            model.addObject("heartRate", patientVitalsDTO.getHeartRate());
            model.addObject("height", patientVitalsDTO.getHeight());
            return model;
        }
        else {

             model = new ModelAndView("Massage");
             model.addObject("massage","Patient is not found");
            return model;
        }
    }

    @PostMapping("/updatePatientVital")
    public ModelAndView PatientVitalsBoard(
            @RequestParam(name = "patientId") int patientId,
            @ModelAttribute PatientVitalsDTO patientVitalsDTO
    ){
        String massage;
        if(patientId>0) {
             massage = patientSevice.UpdatePatientVital(patientId, patientVitalsDTO);
        }
        else
             massage = "Enter correct Id";

        ModelAndView model = new ModelAndView("Massage");
        model.addObject("massage",massage);
        return model;
    }

    @GetMapping("/getdoctorName{specification}")
    public List<DoctorComboDTO> getDoctorCombo(
            @PathVariable(name = "specification") String doctorSpecification
    )
    {
        List<DoctorComboDTO> doctorComboDTOS = doctorSevice.loadDoctorCombo(doctorSpecification);
        return doctorComboDTOS;
    }


}

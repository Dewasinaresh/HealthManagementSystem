package com.HMS.Latest.Controller;

import com.HMS.Latest.DTO.*;
import com.HMS.Latest.Sevice.AppointmentService;
import com.HMS.Latest.Sevice.PatientSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/patient")
public class PatientController {

    public ModelAndView modelAndView=null;
    public String message=null;

    @Autowired
    public PatientSevice patientSevice;

    @Autowired
    public AppointmentService appointmentService;


    @GetMapping("/DashBoard")
    public ModelAndView getmodel(){
        ModelAndView model = new ModelAndView("PatientModule");
        return model;
    }

    @GetMapping("/Register")
    public ModelAndView getRegistration(){
        ModelAndView model = new ModelAndView("PatientRegistration");
        return model;
    }

    @PostMapping("/SaveDeatails")
    public ModelAndView savePatient(
            @ModelAttribute PatientDTO patientDTO
    ){

        ModelAndView model = new ModelAndView("Massage");
         message = patientSevice.createPatient(patientDTO);
        model.addObject("massage",message);
        return model;
    }

    @GetMapping("/ManageViewAppointment")
    public ModelAndView ManageAndViewAppointment(){
        ModelAndView model = new ModelAndView("ViewAppointment");
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

        if(patientId>0) {
            message = patientSevice.UpdatePatientVital(patientId, patientVitalsDTO);
        }
        else
            message = "Enter correct Id";

         modelAndView = new ModelAndView("Massage");
        modelAndView.addObject("massage",message);
        return modelAndView;
    }


    @GetMapping("/BookAppointment")
    public ModelAndView getAppointmentBoard(){
         modelAndView = new ModelAndView("BookAppointment");
        return modelAndView;
    }

    @PostMapping("/SaveBookedAppointment")
    public ModelAndView saveBookedAppointment(
            @ModelAttribute CreateAppointmentDTO createAppointmentDTO
            ){

        message = appointmentService.bookAppointment(createAppointmentDTO);
        modelAndView=new ModelAndView("massage");
        modelAndView.addObject("massage",message);
        return modelAndView;

    }




}

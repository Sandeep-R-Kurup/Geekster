package com.SandeepRKurup.Doctors_Patients.controller;



import com.SandeepRKurup.Doctors_Patients.Repository.DoctorRepository;
import com.SandeepRKurup.Doctors_Patients.model.Doctor;
import com.SandeepRKurup.Doctors_Patients.model.Patients;
import com.SandeepRKurup.Doctors_Patients.service.PatientService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class PatientController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientService patientService;
    @PostMapping(value = "/patient")
    public String savePatient(@RequestBody String patientresponse){
        JSONObject json=new JSONObject(patientresponse);
        Patients patient=setPatient(json);

        patientService.savePatient(patient);
        return "Patient saved";

    }

    private Patients setPatient(JSONObject json) {
        Patients patient=new Patients();
        patient.setPatientId(json.getInt("patientId"));
        patient.setPatientName(json.getString("patientName"));
        patient.setAge(json.getInt("age"));
        patient.setPhoneNumber(json.getString("phoneNumber"));
        patient.setDiseaseType(json.getString("diseaseType"));
        patient.setGender(json.getString("gender"));
        Timestamp currTime=new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(currTime);
        String doctorId=json.getString("doctorId");
        Doctor doctor=doctorRepository.findById(Integer.valueOf(doctorId)).get();
        patient.setDoctorId(doctor);
        return patient;
    }
    @GetMapping("/patient")
    public ResponseEntity getPatient(@Nullable @RequestParam String doctorId, @Nullable @RequestParam String patientId){
        JSONArray patientDetails=patientService.findPatient(patientId,doctorId);
        return new ResponseEntity(patientDetails.toString(), HttpStatus.OK);
    }
}


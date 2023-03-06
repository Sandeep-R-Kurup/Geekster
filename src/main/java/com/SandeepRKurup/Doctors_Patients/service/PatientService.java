package com.SandeepRKurup.Doctors_Patients.service;

import com.SandeepRKurup.Doctors_Patients.Repository.PatientsRepository;
import com.SandeepRKurup.Doctors_Patients.model.Patients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class PatientService {
    @Autowired
    PatientsRepository patientRepository;
    public void savePatient(Patients patient){
        patientRepository.save(patient);
    }

    public JSONArray createResponse(List<Patients> patients){
        JSONArray jsonArray=new JSONArray();
        for(Patients patient:patients){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("patientId",patient.getPatientId());
            jsonObject.put("patient_name",patient.getPatientName());
            jsonObject.put("age",patient.getAge());
            jsonObject.put("phone_number",patient.getPhoneNumber());
            jsonObject.put("disease_type",patient.getDiseaseType());
            jsonObject.put("gender",patient.getGender());
            jsonObject.put("admit_date",patient.getAdmitDate());
            jsonObject.put("doctor_id",patient.getDoctorId().getDoctorId());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
    public JSONArray findPatient(String patientId,String doctorId) {
        List<Patients> allpatients= patientRepository.findAll();
        List<Patients> patients=null;
        JSONArray jsonArray=null;
        if(patientId==null && doctorId==null){
            jsonArray=createResponse(allpatients);
            return jsonArray;
        }
        else if (patientId==null && doctorId!=null) {
            patients=new ArrayList<>();
            for(Patients patient: patients){
                if(patient.getDoctorId().getDoctorId()==Integer.valueOf(doctorId)){
                    patients.add(patient);
                }
            }
            jsonArray=createResponse(patients);
        }
        else {
            patients=new ArrayList<>();
            for(Patients patient: patients){
                if(Objects.equals(patient.getPatientId(), Integer.valueOf(patientId))){
                    patients.add(patient);
                }
            }
            jsonArray=createResponse(patients);
        }
        return jsonArray;
    }
}


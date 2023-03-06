package com.SandeepRKurup.Doctors_Patients.Repository;


import com.SandeepRKurup.Doctors_Patients.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}

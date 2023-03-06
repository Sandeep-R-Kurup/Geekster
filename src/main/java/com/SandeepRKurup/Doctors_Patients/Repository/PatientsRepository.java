package com.SandeepRKurup.Doctors_Patients.Repository;

import com.SandeepRKurup.Doctors_Patients.model.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patients,Integer> {
}


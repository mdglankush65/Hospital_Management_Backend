package com.hospital.management.Hospital.Management.repository;

import com.hospital.management.Hospital.Management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN a.doctor")
    List<Patient> findAllPatientWithAppointment();
}

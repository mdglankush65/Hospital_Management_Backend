package com.hospital.management.Hospital.Management.service;

import com.hospital.management.Hospital.Management.entity.Patient;
import com.hospital.management.Hospital.Management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientById(Long Id){
        Patient patient1 = patientRepository.findById(Id).orElseThrow();
        Patient patient2 = patientRepository.findById(Id).orElseThrow();

        return patient1;
    }

    public Patient getPatientByName(String name){
        return patientRepository.findByName(name);
    }
}

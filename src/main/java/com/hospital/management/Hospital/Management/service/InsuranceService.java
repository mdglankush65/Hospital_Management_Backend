package com.hospital.management.Hospital.Management.service;

import com.hospital.management.Hospital.Management.entity.Insurance;
import com.hospital.management.Hospital.Management.entity.Patient;
import com.hospital.management.Hospital.Management.repository.InsuranceRepository;
import com.hospital.management.Hospital.Management.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id:" + patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); // bidirectional consistency maintenance

        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: "+ patientId));

        patient.setInsurance(null);
        return patient;
    }
}

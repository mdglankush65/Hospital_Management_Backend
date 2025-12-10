package com.hospital.management.Hospital.Management;

import com.hospital.management.Hospital.Management.entity.Patient;
import com.hospital.management.Hospital.Management.repository.PatientRepository;
import com.hospital.management.Hospital.Management.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){

        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1L);

//        Patient patient = patientRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("Patient not found with id 1."));

        Patient patient = patientService.getPatientByName("Diya Patel");
        System.out.println(patient);

    }
}

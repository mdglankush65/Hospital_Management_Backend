package com.hospital.management.Hospital.Management;

import com.hospital.management.Hospital.Management.entity.Insurance;
import com.hospital.management.Hospital.Management.entity.Patient;
import com.hospital.management.Hospital.Management.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("SBI_4536")
                .provider("SBI")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 3L);

        System.out.println("Patient:"+patient);
    }

    @Test
    public void testDisassociateInsuranceFromPatient(){
        Insurance insurance = Insurance.builder()
                .policyNumber("SBI_4536")
                .provider("SBI")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 3L);

        var newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());

        System.out.println(newPatient);
    }
}

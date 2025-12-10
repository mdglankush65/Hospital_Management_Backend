package com.hospital.management.Hospital.Management.service;

import com.hospital.management.Hospital.Management.entity.Appointment;
import com.hospital.management.Hospital.Management.entity.Doctor;
import com.hospital.management.Hospital.Management.entity.Patient;
import com.hospital.management.Hospital.Management.repository.AppointmentRepository;
import com.hospital.management.Hospital.Management.repository.DoctorRepository;
import com.hospital.management.Hospital.Management.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have any ID");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        appointmentRepository.save(appointment);

        return appointment;
    }

    @Transactional
    public Appointment reAssignAppointment(Long appointmentId, Long newDoctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor oldDoctor = doctorRepository.findById(appointment.getDoctor().getId()).orElseThrow();
        Doctor doctor = doctorRepository.findById(newDoctorId).orElseThrow();

        appointment.setDoctor(doctor);
        oldDoctor.getAppointments().remove(appointment);
        doctor.getAppointments().add(appointment);

        appointmentRepository.save(appointment);

        return appointment;
    }
}

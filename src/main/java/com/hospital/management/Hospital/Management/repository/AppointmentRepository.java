package com.hospital.management.Hospital.Management.repository;

import com.hospital.management.Hospital.Management.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

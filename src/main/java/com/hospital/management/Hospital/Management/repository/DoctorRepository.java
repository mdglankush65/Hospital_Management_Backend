package com.hospital.management.Hospital.Management.repository;

import com.hospital.management.Hospital.Management.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

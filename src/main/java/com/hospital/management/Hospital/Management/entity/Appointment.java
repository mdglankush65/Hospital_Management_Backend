package com.hospital.management.Hospital.Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @Column(length = 10)
    private String status;

    @ManyToOne // Owning side
    @JoinColumn(name = "patient_id", nullable = false) // patient is required and not nullable
    private Patient patient;

    @ManyToOne // Owning side
    @JoinColumn(name = "doctor_id", nullable = false) // doctor is required and not nullable
    private Doctor doctor;

}



package com.hospital.management.Hospital.Management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    private String specialization;

    @Column(unique = true, nullable = false)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    @OneToOne(mappedBy = "headDoctor")
    private Department department;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();

}


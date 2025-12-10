package com.hospital.management.Hospital.Management;

import com.hospital.management.Hospital.Management.entity.Appointment;
import com.hospital.management.Hospital.Management.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    AppointmentService appointmentService;

    @Test
    public void testAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,12,8,14,15))
                .status("Pending")
                .reason("Back pain")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment, 3L, 2L);

        System.out.println(newAppointment);
    }

    @Test
    public void testReAssignAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,12,8,14,15))
                .status("Pending")
                .reason("Back pain")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment, 3L, 2L);

        System.out.println(newAppointment);

        Appointment updatedAppointment = appointmentService.reAssignAppointment(newAppointment.getId(), 2L);

        System.out.println(updatedAppointment);
    }
}

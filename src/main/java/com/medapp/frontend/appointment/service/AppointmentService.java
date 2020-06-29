package com.medapp.frontend.appointment.service;

import com.medapp.frontend.appointment.Place;
import com.medapp.frontend.appointment.domain.Appointment;

import java.util.HashSet;
import java.util.Set;

public class AppointmentService {
    private Set<Appointment> appointments;
    private static AppointmentService appointmentService;

    private AppointmentService() {
        this.appointments = appointmentsSet();
    }

    public static  AppointmentService getInstance() {
        if (appointmentService == null) {
            appointmentService = new AppointmentService();
        }
        return appointmentService;
    }

    public Set<Appointment> getAppointments() {
        return new HashSet<>(appointments);
    }

    public void register(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void delete(Appointment appointment) {
        this.appointments.remove(appointment);
    }

    private Set<Appointment> appointmentsSet() {
        Set<Appointment> appointments = new HashSet<>();
        appointments.add(new Appointment(1L, 1, 5, 2020, 07, 05, 15,
                15, Place.JABLKOWA_1_JABLKOWO, 5));
        appointments.add(new Appointment(2L, 2, 7, 2020, 10, 11, 13,
                30, Place.JABLKOWA_2_JABLKOWO, 8));
        return appointments;
    }
}

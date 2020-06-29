package com.medapp.frontend.doctor.service;

import com.medapp.frontend.doctor.domain.Doctor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DoctorService {
    private Set<Doctor> doctors;
    private static DoctorService doctorService;

    private DoctorService() {
        this.doctors = doctorsSet();
    }

    public static  DoctorService getInstance() {
        if (doctorService == null) {
            doctorService = new DoctorService();
        }
        return doctorService;
    }

    public Set<Doctor> getDoctors() {
        return new HashSet<>(doctors);
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void chooseDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void delete(Doctor doctor) {
        this.doctors.remove(doctor);
    }

    private Set<Doctor> doctorsSet() {
        Set<Doctor> doctors = new HashSet<>();
        doctors.add(new Doctor(1L, "Tom", "Morrison", "neurologist"));
        doctors.add(new Doctor(2L, "Barbara", "Willson", "general practicioner"));
        return doctors;
    }

    public Set<Doctor> findBySpecialization(String specialization) {
        return doctors.stream().filter(doctor -> doctor.getSpecialization().contains(specialization)).collect(Collectors.toSet());
    }
}

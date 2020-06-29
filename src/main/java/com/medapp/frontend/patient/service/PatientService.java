package com.medapp.frontend.patient.service;

import com.medapp.frontend.patient.domain.Patient;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PatientService {
    private Set<Patient> patients;
    private static PatientService patientService;

    private PatientService() {
        this.patients = patientsSet();
    }

    public static  PatientService getInstance() {
        if (patientService == null) {
            patientService = new PatientService();
        }
        return patientService;
    }

    public Set<Patient> getPatients() {
        return new HashSet<>(patients);
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void delete(Patient patient) {
        this.patients.remove(patient);
    }

    private Set<Patient> patientsSet() {
        Set<Patient> patients = new HashSet<>();
        patients.add(new Patient(1L, "Ben", "Morris", "87121876961",
                "Bajkowa 5 Bajkowo"));
        patients.add(new Patient(2L, "Ann", "Williams", "65091854129", "Testowa 5 Testowo"));
        patients.add(new Patient(3L, "Jennifer", "Brook", "89012689267",
                "Komputerowa 10 Komputerowo"));
        patients.add(new Patient(4L, "Alex", "Black", "76052273012", "Magiczna 8 Testowo"));
        patients.add(new Patient(5L, "Beatrice", "White", "55080887654",
                "Papierowa 11 Bajkowo"));
        return patients;
    }

    public Set<Patient> findByLastname(String lastname) {
        return patients.stream().filter(patient -> patient.getLast_name().contains(lastname)).collect(Collectors.toSet());
    }
}

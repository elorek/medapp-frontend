package com.medapp.frontend.doctor.domain;

import java.util.Objects;

public class Doctor {
    private Long id;
    private String name;
    private String last_name;
    private String specialization;

    public Doctor() {}

    public Doctor(Long id, String name, String last_name, String specialization) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return id.equals(doctor.id) &&
                name.equals(doctor.name) &&
                last_name.equals(doctor.last_name) &&
                specialization.equals(doctor.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, last_name, specialization);
    }
}

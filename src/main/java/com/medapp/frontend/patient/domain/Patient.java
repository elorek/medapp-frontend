package com.medapp.frontend.patient.domain;

import java.util.Objects;

public class Patient {
    private Long id;
    private String name;
    private String last_name;
    private String pesel;
    private String adress;

    public Patient() {}

    public Patient(Long id, String name, String last_name, String pesel, String adress) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.pesel = pesel;
        this.adress = adress;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return id.equals(patient.id) &&
                name.equals(patient.name) &&
                last_name.equals(patient.last_name) &&
                pesel.equals(patient.pesel) &&
                adress.equals(patient.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, last_name, pesel, adress);
    }
}

package com.medapp.frontend.appointment.domain;

import com.medapp.frontend.appointment.Place;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
    private Long id;
    private int patient_id;
    private int doctor_id;
    private LocalDateTime when;
    private Place where;
    private int room;

    public Appointment() {}

    public Appointment(Long id, int patient_id, int doctor_id, int year, int month, int day, int hour, int minute,
                       Place where, int room) {
        this.id = id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.when = LocalDateTime.of(year, month, day, hour, minute);
        this.where = where;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public Place getWhere() {
        return where;
    }

    public int getRoom() {
        return room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return patient_id == that.patient_id &&
                doctor_id == that.doctor_id &&
                room == that.room &&
                id.equals(that.id) &&
                when.equals(that.when) &&
                where.equals(that.where);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient_id, doctor_id, when, where, room);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public void setWhere(Place where) {
        this.where = where;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}

package com.medapp.frontend;

import com.medapp.frontend.appointment.domain.Appointment;
import com.medapp.frontend.appointment.service.AppointmentService;
import com.medapp.frontend.doctor.domain.Doctor;
import com.medapp.frontend.doctor.service.DoctorService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route(value = "medapp", layout = MainLayout.class)
public class MainView extends VerticalLayout {
    private Grid<Appointment> appointmentGrid = new Grid<>(Appointment.class);
    private Grid<Doctor> doctorGrid = new Grid<>(Doctor.class);

//    Binder<Doctor> doctorBinder = new Binder<>(Doctor.class);
//    Binder<Appointment> appointmentBinder = new Binder<>(Appointment.class);
    private DoctorService doctorService = DoctorService.getInstance();
    private AppointmentService appointmentService = AppointmentService.getInstance();

    public MainView() {

//        appointmentBinder.bindInstanceFields(this);
//        doctorBinder.bindInstanceFields(this);

    }

    private void chooseADoctor() {

    }
}

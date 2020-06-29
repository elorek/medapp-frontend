package com.medapp.frontend;

import com.medapp.frontend.appointment.AppointmentForm;
import com.medapp.frontend.appointment.AppointmentView;
import com.medapp.frontend.doctor.DoctorView;
import com.medapp.frontend.patient.PatientForm;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Med application");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink newPatient = new RouterLink("Add a new patient", PatientForm.class);
        RouterLink appointments = new RouterLink("Appointments", AppointmentView.class);
        appointments.setHighlightCondition(HighlightConditions.sameLocation());
        RouterLink chooseADoctor = new RouterLink("Choose a doctor", DoctorView.class);
        RouterLink makeAnAppointment = new RouterLink("Make an appointment", AppointmentForm.class);

        addToDrawer(new VerticalLayout(newPatient, appointments, chooseADoctor, makeAnAppointment));
    }
}

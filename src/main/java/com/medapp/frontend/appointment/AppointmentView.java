package com.medapp.frontend.appointment;

import com.medapp.frontend.appointment.domain.Appointment;
import com.medapp.frontend.appointment.service.AppointmentService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("appointments")
public class AppointmentView extends VerticalLayout {
    private AppointmentService appointmentService = AppointmentService.getInstance();
    private Grid grid = new Grid<>(Appointment.class);
    private TextField filter = new TextField();

    public AppointmentView() {
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        grid.setColumns("id", "patient_id", "doctor_id", "when", "where", "room");

        add(filter, grid);
        setSizeFull();
    }

    public void refresh() {
        grid.setItems(appointmentService.getAppointments());
    }
}

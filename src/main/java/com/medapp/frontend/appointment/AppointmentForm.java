package com.medapp.frontend.appointment;

import com.medapp.frontend.appointment.domain.Appointment;
import com.medapp.frontend.appointment.service.AppointmentService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("newAppointment")
public class AppointmentForm extends FormLayout {
    private TextField doctorSpecialization = new TextField("doctor specialization");
    private ComboBox<Place> placeComboBox = new ComboBox<>("place");
    private TextField when = new TextField("date and time");
    private Button register = new Button("register new appointment");
    private Button delete = new Button("delete appointment");
    private Binder<Appointment> appointmentBinder = new Binder<>(Appointment.class);
    private AppointmentService appointmentService = AppointmentService.getInstance();
    private AppointmentView appointmentView = new AppointmentView();

    public AppointmentForm() {
        placeComboBox.setItems(Place.values());
        HorizontalLayout buttons = new HorizontalLayout(register, delete);
        register.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(doctorSpecialization, placeComboBox, when, buttons);
        appointmentBinder.bindInstanceFields(this);
        register.addClickListener(event -> register());
        delete.addClickListener(event -> delete());
    }

    private void register() {
        Appointment appointment = appointmentBinder.getBean();
        appointmentService.register(appointment);
        appointmentView.refresh();
        setAppointment(null);
    }

    private void delete() {
        Appointment appointment = appointmentBinder.getBean();
        appointmentService.delete(appointment);
        appointmentView.refresh();
        setAppointment(null);
    }

    private void setAppointment(Appointment appointment) {
        appointmentBinder.setBean(appointment);
        if (appointment == null) {
            setVisible(false);
        } else {
            setVisible(true);
        }
    }
}
